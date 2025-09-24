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
        this.status = status;
    }

    private String texto;


    private int status;

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getTopico() {
        return topico;
    }

    public void setTopico(Integer topico) {
        this.topico = topico;
    }

    public Integer getResposta() {
        return resposta;
    }

    public void setResposta(Integer resposta) {
        this.resposta = resposta;
    }

    private Integer usuario;

    private Integer post;

    private Integer topico;

    private Integer resposta;
}
