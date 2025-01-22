package com.cursos.modulos.curso.Curso.DAOs;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursos.modulos.curso.Curso.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CursoDAOJpaImpl implements CursoDAO {

    private EntityManager entityManager;

   
    public CursoDAOJpaImpl(EntityManager oentityManager){
        entityManager = oentityManager;
    }


    @Override
    public List<Curso> findAll() {
        TypedQuery<Curso> theQuery = entityManager.createQuery("from Curso", Curso.class);

        List<Curso> curso = theQuery.getResultList();


        return curso;
    }


    @Override
    public Curso findById(int oId) {

        Curso oCurso = entityManager.find(Curso.class, oId);

        return oCurso;

    }



    @Override
    public void save(Curso oCurso) {
        entityManager.persist(oCurso);
    }



    @Override
    public void deleteById(int oId) {

        Curso oCurso = entityManager.find(Curso.class, oId);

        entityManager.remove(oCurso);

    }
}
