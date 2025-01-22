package com.cursos.modulos.curso.Curso;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cursos.modulos.curso.Curso.DTOs.CursoDTO;
import com.cursos.modulos.curso.Curso.Imagem.Imagem;
import com.cursos.modulos.curso.Curso.Services.CursoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private CursoService cursoService;
    private CursoDTO cursoDTO;

    private Imagem imagem;

    public CursoController(CursoService oCursoService, CursoDTO cursoDTO, Imagem imagem){
        cursoService = oCursoService;
        this.cursoDTO = cursoDTO;
        this.imagem = imagem;
    }


    //CRUD DOS CURSOS
    @GetMapping("/list")
    public String listCursos(Model theModel){
        List<Curso> osCursos = cursoService.findAll();
        theModel.addAttribute("curso", osCursos);


        return "curso/list-cursos";
    }

    //DISPLAY IMAGENS
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("imagemid") Integer id) throws IOException, SQLException {
        Curso curso = cursoService.findById(id);

        // Get the Base64 encoded string from the Blob
        String base64Image = new String(curso.getImagem().getBytes(1, (int) curso.getImagem().length()));

        // Decode the Base64 string to byte array
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @GetMapping("/listarTodos")
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }


    //ADICIONAR IMAGEM
    @GetMapping("/addImage")
    public ModelAndView addImage(){
        return new ModelAndView("imagem/addimage");
    }

    @PostMapping("/addImage")
    public String addImagePost(HttpServletRequest request,@RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();

        String base64Image = Base64.getEncoder().encodeToString(bytes);
        Blob blob = new javax.sql.rowset.serial.SerialBlob(base64Image.getBytes());

        imagem.setImagem(blob);
        cursoDTO.setImagem(imagem);

        return "redirect:/cursos/mostrarFormCadastrarCurso";
    }

    //ADICIONAR CURSO
    @GetMapping("/mostrarFormCadastrarCurso")
    public String mostrarFormCadastrarCurso(Model model, HttpServletRequest request) {

        Curso curso = new Curso();
        model.addAttribute("curso", curso);

        return "curso/curso-form";
    }

    @PostMapping("/save")
    public String saveCurso(
            HttpServletRequest request, RedirectAttributes redirectAttributes, @ModelAttribute("curso") Curso oCurso
    ) throws SQLException, IOException , SerialException {

        oCurso.setImagem(imagem.getImagem());
        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }


    //UPDATE IMAGEM

    @GetMapping("/updateImage")
    public ModelAndView updateImage(@RequestParam("cursoid") Integer id, Model theModel){
        return new ModelAndView("imagem/updateimage");
    }

    @PostMapping("/updateImage")
    public String updateImage(HttpServletRequest request, @RequestParam("imagem") MultipartFile file) throws IOException, SerialException, SQLException {

        Integer cursoId = Integer.valueOf(request.getParameter("cursoid"));

        byte[] bytes = file.getBytes();

        String base64Image = Base64.getEncoder().encodeToString(bytes);
        Blob blob = new javax.sql.rowset.serial.SerialBlob(base64Image.getBytes());

        imagem.setImagem(blob);
        cursoDTO.setImagem(imagem);


        return "redirect:/cursos/mostrarFormAtualizarCurso?cursoid=" + cursoId;
    }


    @GetMapping("/mostrarFormAtualizarCurso")
    public String mostrarFormAtualizarCurso(@RequestParam("cursoid") Integer id, Model theModel){
        Curso oCurso = cursoService.findById(id);
        theModel.addAttribute("curso", oCurso);
        return "curso/update-curso";
    }

    @PostMapping("/saveUpdate")
    public String saveCursoUpdate(
            HttpServletRequest request, RedirectAttributes redirectAttributes, @ModelAttribute("curso") Curso oCurso
    ) throws SQLException, IOException , SerialException {

        oCurso.setImagem(imagem.getImagem());
        cursoService.save(oCurso);

        return "redirect:/cursos/list";
    }


    //DELETAR CURSO
    @GetMapping("/deletar")
    public String deletar(@RequestParam("cursoid") int oId){
        cursoService.deleteById(oId);
        return "redirect:/cursos/list";
    }




}
