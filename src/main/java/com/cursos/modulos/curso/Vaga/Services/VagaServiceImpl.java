package com.cursos.modulos.curso.Vaga.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.modulos.curso.Empresa.Empresa;
import com.cursos.modulos.curso.Empresa.DAOs.EmpresaDAO;
import com.cursos.modulos.curso.Vaga.Vaga;
import com.cursos.modulos.curso.Vaga.DAOs.VagaDAO;

import jakarta.transaction.Transactional;

@Service
public class VagaServiceImpl implements VagaService {

    private VagaDAO vagaDAO;
    @Autowired
    private EmpresaDAO empresaDAO;

    public VagaServiceImpl(VagaDAO aVagaDAO){
        vagaDAO = aVagaDAO;
    }

    @Override
    public List<Vaga> findAll() {
        return vagaDAO.findAll();
    }

    @Override
    public Vaga findById(int oId) {
        return vagaDAO.findById(oId);
    }

    @Transactional
    @Override
    public Vaga save(Vaga aVaga) {
        try {
            Empresa empresa = empresaDAO.findById(aVaga.getEmpresa().getId());
            // Log the empresa details
            System.out.println("Empresa details: " + empresa);

            aVaga.setEmpresa(empresa);
            Vaga savedVaga = vagaDAO.save(aVaga);
            System.out.println("Vaga saved successfully: " + savedVaga);

            return savedVaga;
        } catch (Exception e) {
            System.err.println("Error saving Vaga: " + e.getMessage());
            throw e;
        }
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        vagaDAO.deleteById(oId);
    }
}