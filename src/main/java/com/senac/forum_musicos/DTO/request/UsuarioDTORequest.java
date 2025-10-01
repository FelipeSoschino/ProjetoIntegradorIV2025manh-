package com.senac.forum_musicos.DTO.request;


import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public class UsuarioDTORequest {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    private String nome;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    private String senha;

    private String bio;
    private List<String> roleList;



    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    private File foto;
    private LocalDateTime data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;
    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

}
