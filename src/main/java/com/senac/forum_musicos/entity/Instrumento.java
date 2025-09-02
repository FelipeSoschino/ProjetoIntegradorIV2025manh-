package com.senac.forum_musicos.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Instrumento")
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
}
