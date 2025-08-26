package com.senac.forum_musicos.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="usuario_id")
    private int id;

    @Column(name = "usuario_nome")
    private String nome;
    @Column(name = "usuario_senhaHash")
    private String senha;
    @Column(name= "usuario_bio")
    private String bio;
    @Column(name= "usuario_foto")
    private String foto;
    @Column(name= "usuario_datacriacao")
    private Timestamp data;
    @Column(name="usuario_status")
    private int status;

}
