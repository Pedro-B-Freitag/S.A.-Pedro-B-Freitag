package com.cursos.modulos.curso.Empresa.Service;

import java.util.List;

import com.cursos.modulos.curso.Empresa.Empresa;

public interface EmpresaService {

    List<Empresa> findAll();
    Empresa findById(int oId);
    Empresa save(Empresa aEmpresa);
    void deleteById(int oId);

}
