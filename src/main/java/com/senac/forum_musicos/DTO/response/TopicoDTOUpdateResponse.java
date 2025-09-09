package com.senac.forum_musicos.DTO.response;

public class TopicoDTOUpdateResponse {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int id;

    private int status;
}
