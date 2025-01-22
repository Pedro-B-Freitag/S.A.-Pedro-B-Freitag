package com.cursos.modulos.curso.Usuario.Service;

import com.cursos.modulos.curso.Usuario.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(int oId);
    Usuario save(Usuario oUsuario);
    void deleteById(int oId);

}
