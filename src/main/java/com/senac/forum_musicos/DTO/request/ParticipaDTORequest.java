package com.senac.forum_musicos.DTO.request;

public class ParticipaDTORequest {

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(int topicoId) {
        this.topicoId = topicoId;
    }

    private int usuarioId;

    private int topicoId;

}
