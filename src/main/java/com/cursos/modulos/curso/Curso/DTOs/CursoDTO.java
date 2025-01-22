package com.cursos.modulos.curso.Curso.DTOs;

import org.springframework.stereotype.Component;

import com.cursos.modulos.curso.Curso.Imagem.Imagem;

@Component
public class CursoDTO {

    private Imagem imagem;

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
}
