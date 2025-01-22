package com.cursos.modulos.curso.Usuario;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursos.modulos.curso.Usuario.Service.UsuarioService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;


    public PessoaController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }






    @GetMapping("/list")
    public String listUsuarios(Model theModel){
        List<Usuario> osUsuarios = usuarioService.findAll();
        theModel.addAttribute("usuario", osUsuarios);

        return "pessoa/list-pessoas";
    }

    @GetMapping("/mostrarFormCadastrarPessoa")
    public String mostrarFormCadastrarPessoa(Model theModel){
        Usuario oUsuario = new Usuario();

        theModel.addAttribute("usuario", oUsuario);

        return "pessoa/pessoa-form";
    }



    @PostMapping("/save")
    public String savePessoa(@ModelAttribute("usuario") Usuario oUsuario){
        String hashedPassword = passwordEncoder.encode(oUsuario.getSenha());
        oUsuario.setSenha(hashedPassword);

        usuarioService.save(oUsuario);

        return "redirect:/pessoas/list";
    }




    @GetMapping("/mostrarFormAtualizarPessoa")
    public String mostrarFormAtualizarPessoa(@RequestParam("usuarioid") int oId, Model theModel){

        Usuario oUsuario = usuarioService.findById(oId);
        oUsuario.setSenha(null);

        theModel.addAttribute("usuario", oUsuario);


        return "pessoa/pessoa-form";

    }


    @GetMapping("/deletar")
    public String deletar(@RequestParam("usuarioid") int oId){
        usuarioService.deleteById(oId);

        return "redirect:/pessoas/list";
    }




}
