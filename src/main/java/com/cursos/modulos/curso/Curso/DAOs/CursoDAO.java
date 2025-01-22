package com.cursos.modulos.curso.Curso.DAOs;

import java.util.List;

import com.cursos.modulos.curso.Curso.Curso;

public interface CursoDAO {

    List<Curso> findAll();
    Curso findById(int oId);
    void save(Curso oCurso);
    void deleteById(int oId);

}
