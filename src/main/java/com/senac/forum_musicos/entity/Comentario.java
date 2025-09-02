package com.senac.forum_musicos.entity;

import jakarta.persistence.*;

@Entity
@Table(name="comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
}
