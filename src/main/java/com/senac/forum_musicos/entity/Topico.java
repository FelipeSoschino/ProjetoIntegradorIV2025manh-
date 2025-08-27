package com.senac.forum_musicos.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="topico_id")
    private int id;

    @Column(name="topico_titulo")
    private String titulo;

    @Column(name = "topico_descricao")
    private String descricao;

    @Column(name="topico_data")
    private LocalDateTime data;

    @Column(name="topico_status")
    private int status;

    @Column(name="topico_categoria")
    private int categoria;



}
