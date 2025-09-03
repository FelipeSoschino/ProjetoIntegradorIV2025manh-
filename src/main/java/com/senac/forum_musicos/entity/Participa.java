package com.senac.forum_musicos.entity;

import jakarta.persistence.*;

@Entity
@Table(name="participa")
public class Participa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participa_id")
    private int id;

}
