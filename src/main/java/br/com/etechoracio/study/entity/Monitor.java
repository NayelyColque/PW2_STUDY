package br.com.etechoracio.study.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "TBL_MONITOR")
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MONITOR")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_FOTO")
    private String foto;

    @Column(name = "TX_WHATSAPP")
    private String whatsapp;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_TELEFONE")
    private String telefone;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public String getFoto() {
        return foto;
    }

    public String getEmail() {
        return email;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Disponibilidade> getDisponibilidades() {
        return disponibilidades;
    }

    @Column(name = "TX_CONTEUDO")
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "ID_DISCIPLINA")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(name = "TBL_REL_MONITOR_DISPONIBILIDADE",
            joinColumns = @JoinColumn(name = "ID_MONITOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_DISPONIBILIDADE")
    )
    private List<Disponibilidade> disponibilidades;
}
