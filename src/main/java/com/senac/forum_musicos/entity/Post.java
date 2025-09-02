package com.senac.forum_musicos.entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.time.LocalDateTime;

@Entity
@Table(name="post")
public class Post {
    /*id, texto, arquivo, data, status*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private int id;

    @Column(name="post_texto")
    private String texto;

    @Column(name="post_data_criacao")
    private LocalDateTime data;

    @Column(name="post_status")
    private int status;
}
