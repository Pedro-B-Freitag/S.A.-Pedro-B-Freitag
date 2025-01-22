package com.cursos.modulos.curso.App.ControllerTelas.DAO;

import org.springframework.stereotype.Repository;

import com.cursos.modulos.curso.Usuario.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Usuario oUsuario) {
        entityManager.persist(oUsuario);
    }

    @Override
    public Usuario findPessoaById(int oId) {
        return entityManager.find(Usuario.class, oId);
    }

    @Override
    @Transactional
    public void deletePessoaById(int oId) {
        Usuario tempUsuario = entityManager.find(Usuario.class, oId);

        entityManager.remove(tempUsuario);
    }
}
