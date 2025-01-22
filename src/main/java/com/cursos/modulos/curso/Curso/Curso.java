package com.cursos.modulos.curso.Curso;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private int id;
    @Column(name = "curso_descricao")
    private String descricao;
    @Column(name = "curso_categoria")
    private String categoria;
    @Column(name = "curso_fornecedor")
    private String fornecedor;
    @Column(name = "curso_nome")
    private String nome;
    @Column(name = "curso_url")
    private String url;
    @Column(name = "curso_presencial")
    private String presencial;
    @Column(name = "curso_visualizacao")
    private Integer visualizacao;
    @Column(name = "curso_qtd_hrs")
    private String qtdHoras;
    @Lob
    @Column(name ="curso_imagem")
    private Blob imagem;

    public Curso(){

    }

    public Curso(String descricao, String categoria, String fornecedor, String nome,
                 String url, String presencial, Integer visualizacao,
                 String qtdHoras, Blob imagem) {

        this.descricao = descricao;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.nome = nome;
        this.url = url;
        this.presencial = presencial;
        this.visualizacao = visualizacao;
        this.qtdHoras = qtdHoras;
        this.imagem = imagem;

    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", nome='" + nome + '\'' +
                ", url='" + url + '\'' +
                ", presencial=" + presencial +
                ", visualizacao=" + visualizacao +
                ", qtdHoras='" + qtdHoras + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }


}
