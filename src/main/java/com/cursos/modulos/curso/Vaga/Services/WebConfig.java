package com.cursos.modulos.curso.Vaga.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cursos.modulos.curso.Vaga.StringToEmpresaConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StringToEmpresaConverter stringToEmpresaConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToEmpresaConverter);
    }
}