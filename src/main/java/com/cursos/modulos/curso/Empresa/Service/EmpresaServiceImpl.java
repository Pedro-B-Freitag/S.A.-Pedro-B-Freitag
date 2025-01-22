package com.cursos.modulos.curso.Empresa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cursos.modulos.curso.Empresa.Empresa;
import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;

import jakarta.transaction.Transactional;
@Service
public class EmpresaServiceImpl implements EmpresaService{


    private EmpresaDAO empresaDAO;

    public EmpresaServiceImpl(EmpresaDAO aEmpresaDAO){
        empresaDAO = aEmpresaDAO;
    }


    @Override
    public List<Empresa> findAll() {
        return empresaDAO.findAll();
    }

    @Override
    public Empresa findById(int oId) {
        return empresaDAO.findById(oId);
    }

    @Transactional
    @Override
    public Empresa save(Empresa aEmpresa) {
        return empresaDAO.save(aEmpresa);
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        empresaDAO.deleteById(oId);
    }
}
