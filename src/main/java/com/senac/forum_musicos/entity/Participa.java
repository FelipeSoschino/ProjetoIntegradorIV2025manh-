package com.senac.forum_musicos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="participa")
public class Participa {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participa_id")
    private int id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "participa_status")
    private int status;


    public int getIdUsuario() {
        return idUsuario = this.usuario.getId();
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Transient
    @JsonProperty("idUsuario")
    private int idUsuario;

    public int getIdTopico() {
        return idTopico = this.topico.getId();
    }

    public void setIdTopico(int idTopico) {
        this.idTopico = idTopico;
    }

    @Transient
    @JsonProperty("idTopico")
    private int idTopico;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;



}
