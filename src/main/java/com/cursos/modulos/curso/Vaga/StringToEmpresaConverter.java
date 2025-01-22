package com.cursos.modulos.curso.Vaga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cursos.modulos.curso.Empresa.Empresa;
import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;

@Component
public class StringToEmpresaConverter implements Converter<String, Empresa> {
    @Autowired
    private EmpresaDAO empresaDAO;

    @Override
    public Empresa convert(String id) {
        return empresaDAO.findById(Integer.parseInt(id));
    }
}