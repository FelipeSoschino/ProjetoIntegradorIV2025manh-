package com.senac.forum_musicos.DTO.request;

public class ComentarioDTORequest {

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        status = status;
    }

    private String texto;

    private int status;
}
