package com.senac.forum_musicos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="instrumento")
public class Instrumento {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="instrumento_id")
    private int id;
    @Column(name="instrumento_nome")
    private String nome;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;




}
