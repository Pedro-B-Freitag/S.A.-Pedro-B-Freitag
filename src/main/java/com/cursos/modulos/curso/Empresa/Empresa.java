package com.cursos.modulos.curso.Empresa;

        import jakarta.persistence.*;
        import lombok.Getter;
        import lombok.Setter;

@Entity
@Table(name = "empresa")
@Getter
@Setter

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Integer id;
    @Column(name = "empresa_cnpj")
    private String cnpj;
    @Column(name = "empresa_nome")
    private String nome;
    @Column(name = "empresa_cep")
    private String cep;
    @Column(name = "empresa_UF")
    private String uf;
    @Column(name = "empresa_cidade")
    private String cidade;
    @Column(name = "empresa_endereco")
    private String endereco;
    @Column(name = "empresa_email")
    private String email;
    @Column(name = "empresa_contato")
    private String contato;

    public Empresa(){

    }

    public Empresa(String cnpj, String nome, String cep, String uf,
                   String cidade, String endereco, String email, String contato) {

        this.cnpj = cnpj;
        this.nome = nome;
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
        this.endereco = endereco;
        this.email = email;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
                ", uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}