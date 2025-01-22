package com.cursos.modulos.curso.App.ControllerTelas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String Login(){
        return "login";
    }

}
