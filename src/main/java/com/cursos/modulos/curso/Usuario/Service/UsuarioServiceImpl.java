package com.cursos.modulos.curso.Usuario.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cursos.modulos.curso.Usuario.Usuario;
import com.cursos.modulos.curso.Usuario.DAOs.UsuarioDAO;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(UsuarioDAO oUsuarioDAO){
        usuarioDAO = oUsuarioDAO;
    }


    @Override
    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    public Usuario findById(int oId) {
        return usuarioDAO.findById(oId);
    }

    @Transactional
    @Override
    public Usuario save(Usuario oUsuario) {
        return usuarioDAO.save(oUsuario);
    }

    @Transactional
    @Override
    public void deleteById(int oId) {
        usuarioDAO.deleteById(oId);
    }
}
