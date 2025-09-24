package com.senac.forum_musicos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comentario_id")
    private int id;

    @Column(name="comentario_texto")
    private String texto;

    @Column(name="comentario_status")
    private int status;

    @OneToMany(mappedBy = "comentario")
    public Set<Comentario> comentarios;

    public int getIdUsuario() {
        return idUsuario = this.usuario.getId();
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPost() {
        return idPost = this.post.getId();
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdTopico() {
        return idTopico = this.topico.getId();
    }

    public void setIdTopico(int idTopico) {
        this.idTopico = idTopico;
    }

    @Transient
    @JsonProperty("idUsuario")
    private int idUsuario;

    @Transient
    @JsonProperty("idPost")
    private int idPost;

    @Transient
    @JsonProperty("idTopico")
    private int idTopico;

    public int getIdResposta() {
        return idResposta = this.comentario.getId();
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    @Transient
    @JsonProperty("idResposta")
    private int idResposta;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "topico_id", nullable = true)
    private Topico topico;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "comentario_resposta_id")
    private Comentario comentario; // Comentario Resposta

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
}
