package com.cursos.modulos.curso.Usuario.DAOs;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursos.modulos.curso.Usuario.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UsuarioDAOJpaImpl implements UsuarioDAO {

    private EntityManager entityManager;


    public UsuarioDAOJpaImpl(EntityManager oentityManager){
        entityManager = oentityManager;
    }


    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> theQuery = entityManager.createQuery("from Usuario", Usuario.class);

        List<Usuario> usuario = theQuery.getResultList();


        return usuario;
    }




    @Override
    public Usuario findById(int oId) {
        Usuario aPessoa = entityManager.find(Usuario.class, oId);

        return aPessoa;
    }

    @Override
    public Usuario save(Usuario aPessoa) {
        Usuario bdPessoa = entityManager.merge(aPessoa);

        return bdPessoa;
    }

    @Override
    public void deleteById(int oId) {

        Usuario aPessoa = entityManager.find(Usuario.class, oId);

        entityManager.remove(aPessoa);

    }
}
