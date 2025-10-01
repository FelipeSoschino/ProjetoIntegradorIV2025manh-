package com.senac.forum_musicos.DTO.request;

public class UsuarioDTOLoginRequest {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    private String senha;



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}