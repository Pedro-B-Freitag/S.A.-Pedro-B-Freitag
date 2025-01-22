package com.cursos.modulos.curso.Usuario;

import com.cursos.modulos.curso.Roles.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usuarios")
@Entity
@Getter
@Setter

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;
    @Column(name = "usuario_cpf")
    private String cpf;
    @Column(name = "usuario_email")
    private String email;
    @Column(name = "usuario_senha")
    private String senha;
    @Column(name = "usuario_ativado")
    private Integer ativado;
    @OneToOne
    @JoinColumn(name = "roles_id")
    private Roles roles;



    public Usuario(){}

    public Usuario(Integer id, String cpf, String email, String senha, Integer ativado) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.ativado = ativado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ativado=" + ativado +
                ", roles=" + roles +
                '}';
    }
}
