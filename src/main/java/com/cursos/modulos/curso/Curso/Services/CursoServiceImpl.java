package com.cursos.modulos.curso.Curso.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.modulos.curso.Curso.Curso;
import com.cursos.modulos.curso.Curso.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    public Curso findById(Integer oId) {
        return cursoRepository.findById(oId).get();
    }

    @Override
    public void save(Curso oCurso) {
        cursoRepository.save(oCurso);
    }

    @Transactional
    @Override
    public void deleteById(Integer oId) {
        cursoRepository.deleteById(oId);
    }
}
