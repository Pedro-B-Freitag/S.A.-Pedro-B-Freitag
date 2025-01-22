package com.cursos.modulos.curso.Empresa.DAOs;

import java.util.List;

import com.cursos.modulos.curso.Empresa.Empresa;

public interface EmpresaDAO {
    List<Empresa> findAll();
    Empresa findById(int oId);
    Empresa save(Empresa aEmpresa);
    void deleteById(int oId);
}
