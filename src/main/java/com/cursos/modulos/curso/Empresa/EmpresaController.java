package com.cursos.modulos.curso.Empresa;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursos.modulos.curso.Empresa.Service.EmpresaService;
import com.cursos.modulos.curso.Usuario.PessoaRepository;
import com.cursos.modulos.curso.Usuario.Usuario;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    private EmpresaService empresaService;

    private PessoaRepository pessoaDAO;



    public EmpresaController(EmpresaService aEmpresaService){
        empresaService = aEmpresaService;
    }


    @GetMapping("/list")
    public String listEmpresas(Model theModel){
        List<Empresa> asEmpresas = empresaService.findAll();
        theModel.addAttribute("listempresa", asEmpresas);

        theModel.addAttribute("empresa", new Empresa());

        return "empresa/list-empresas";
    }


    @GetMapping("/mostrarFormCadastrarEmpresa")
    public String mostrarFormCadastrarEmpresa(Model theModel){

        Empresa aEmpresa = new Empresa();
        theModel.addAttribute("empresa", aEmpresa);

        return "Empresa/empresa-form";
    }


    @PostMapping("/save")
    public String saveEmpresa(@ModelAttribute("empresa") Empresa aEmpresa){
        empresaService.save(aEmpresa);

        return "redirect:/empresas/list";
    }


    @GetMapping("/mostrarFormAtualizarEmpresa")
    public String mostrarFormAtualizarEmpresa(@RequestParam("empresaid") int oId, Model theModel){

        Empresa aEmpresa = empresaService.findById(oId);

        theModel.addAttribute("empresa", aEmpresa);


        return "empresa/empresa-form";

    }

    @GetMapping("/deletar")
    public String deletar(@RequestParam("empresaid") int oId){
        empresaService.deleteById(oId);

        return "redirect:/empresas/list";
    }

    public String customSelectBox(Model model) {
        List<Usuario> usuarios = pessoaDAO.findAll();
        model.addAttribute("usuarios", usuarios);
        return "empresa/empresa-form";
    }



}
