package com.senac.forum_musicos.DTO.request;

import java.io.File;
import java.sql.Blob;
import java.time.LocalDateTime;

public class PostDTORequest {

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    private String texto;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getTopico() {
        return topico;
    }

    public void setTopico(Integer topico) {
        this.topico = topico;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    private int usuario;
    private Integer topico;

    private File arquivo;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    private LocalDateTime data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;


}
