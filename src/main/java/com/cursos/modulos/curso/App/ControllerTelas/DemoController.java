package com.cursos.modulos.curso.App.ControllerTelas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }


}
