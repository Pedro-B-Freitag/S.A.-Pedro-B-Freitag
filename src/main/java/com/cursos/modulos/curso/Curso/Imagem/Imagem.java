package com.cursos.modulos.curso.Curso.Imagem;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.sql.Blob;
@Component
public class Imagem {
    @Lob
    private Blob imagem;

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

}
