package com.cursos.modulos.curso.Roles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter


public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "role")
    private String  role;


    public Roles(){}

    public Roles(String role) {
        this.role = role;

    }

    @Override
    public String toString() {
        return "Roles{"    +
                "id="      + id    +
                ", role='" + role  +  '\'' +
                '}';
    }
}
