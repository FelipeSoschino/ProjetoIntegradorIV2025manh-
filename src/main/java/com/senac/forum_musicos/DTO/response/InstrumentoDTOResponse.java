package com.senac.forum_musicos.DTO.response;

public class InstrumentoDTOResponse {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nome;

    private int id;
}
