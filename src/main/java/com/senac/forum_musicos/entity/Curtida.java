package com.senac.forum_musicos.entity;

import jakarta.persistence.*;

@Entity
@Table(name="curtida")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
}
