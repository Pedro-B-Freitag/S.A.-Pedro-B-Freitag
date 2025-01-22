package com.cursos.modulos.curso.Empresa.DAOs;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cursos.modulos.curso.Empresa.Empresa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class EmpresaDAOJpaImpl implements EmpresaDAO{

    private EntityManager entityManager;

    public EmpresaDAOJpaImpl(EntityManager oentityManager){
        entityManager = oentityManager;
    }


    @Override
    public List<Empresa> findAll() {

        TypedQuery<Empresa> theQuery = entityManager.createQuery("from Empresa", Empresa.class);
        List<Empresa> empresa = theQuery.getResultList();

        return empresa;
    }




    @Override
    public Empresa findById(int oId) {
        Empresa aEmpresa = entityManager.find(Empresa.class, oId);
        return aEmpresa;
    }

    @Override
    public Empresa save(Empresa aEmpresa) {
        Empresa bdEmpresa = entityManager.merge(aEmpresa);

        return bdEmpresa;
    }

    @Override
    public void deleteById(int oId) {

        Empresa aEmpresa = entityManager.find(Empresa.class, oId);

        entityManager.remove(aEmpresa);

    }
}
