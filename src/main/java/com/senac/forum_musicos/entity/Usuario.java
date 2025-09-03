package com.senac.forum_musicos.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Set;

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
    private Blob foto;
    @Column(name= "usuario_datacriacao")
    private LocalDateTime data;
    @Column(name="usuario_status")
    private int status;



    @OneToMany(mappedBy = "usuario")
    public Set<Instrumento> instrumentos;

    @OneToMany(mappedBy = "usuario")
    public Set<Topico> topicos;

    @OneToMany(mappedBy = "usuario")
    public Set<Post> posts;

    @OneToMany(mappedBy = "usuario")
    public Set<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    public Set<Curtida> curtidas;

    @OneToMany(mappedBy = "usuario")
    public Set<Participa> participa;


}
