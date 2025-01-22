package com.cursos.modulos.curso.App.ControllerTelas.DAO;


import com.cursos.modulos.curso.Usuario.Usuario;

public interface AppDAO {
    void save(Usuario oUsuario);
    Usuario findPessoaById(int oId);

    void deletePessoaById(int oId);
}
