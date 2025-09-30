package com.senac.forum_musicos.DTO.response;

public class ParticipaDTOResponse {

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;


    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getTopicoId() {
        return idTopico;
    }

    public void setTopicoId(Integer idTopico) {
        this.idTopico = idTopico;
    }

    private int usuarioId;

    private Integer idTopico;



}
