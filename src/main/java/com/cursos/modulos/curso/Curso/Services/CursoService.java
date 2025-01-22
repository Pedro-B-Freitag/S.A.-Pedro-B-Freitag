package com.cursos.modulos.curso.Curso.Services;

import java.util.List;

import com.cursos.modulos.curso.Curso.Curso;

public interface CursoService {
    List<Curso> findAll();

    Curso findById(Integer oId);

    void save(Curso oCurso);

    void deleteById(Integer oId);
}
