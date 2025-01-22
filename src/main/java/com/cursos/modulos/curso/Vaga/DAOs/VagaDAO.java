package com.cursos.modulos.curso.Vaga.DAOs;

import com.cursos.modulos.curso.Vaga.Vaga;

import java.util.List;

public interface VagaDAO {

    List<Vaga> findAll();
    Vaga findById(int oId);
    Vaga save(Vaga aVaga);
    void deleteById(int oId);

}
