package com.senac.forum_musicos.service;

import com.senac.forum_musicos.DTO.request.ComentarioDTORequest;
import com.senac.forum_musicos.DTO.request.ComentarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTORequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.ComentarioDTOResponse;
import com.senac.forum_musicos.DTO.response.ComentarioDTOUpdateResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOUpdateResponse;
import com.senac.forum_musicos.entity.Comentario;
import com.senac.forum_musicos.entity.Post;
import com.senac.forum_musicos.entity.Topico;
import com.senac.forum_musicos.entity.Usuario;
import com.senac.forum_musicos.repository.ComentarioRepository;
import com.senac.forum_musicos.repository.PostRepository;
import com.senac.forum_musicos.repository.TopicoRepository;
import com.senac.forum_musicos.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private ComentarioRepository comentarioRepository;

    private UsuarioRepository usuarioRepository;
    private PostRepository postRepository;
    private TopicoRepository topicoRepository;

    public ComentarioService(ComentarioRepository comentarioRepository){
        this.comentarioRepository = comentarioRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Comentario> listarComentarios(){
        return this.comentarioRepository.listarComentarios();
    }

    public Comentario listarComentarioPorId(Integer cometarioId){
        return this.comentarioRepository.listarComentarioPorId(cometarioId);

    }


    public ComentarioDTOResponse criarComentario(ComentarioDTORequest comentarioDTORequest){
        Usuario usuario = usuarioRepository.findById(comentarioDTORequest.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Post post = postRepository.findById(comentarioDTORequest.getPost())
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        Topico topico = topicoRepository.findById(comentarioDTORequest.getTopico()).orElse(null);

        Comentario comentario = new Comentario();
        comentario.setStatus(comentarioDTORequest.getStatus());
        comentario.setTexto(comentarioDTORequest.getTexto());
        comentario.setUsuario(usuario);
        comentario.setPost(post);
        comentario.setTopico(topico);

        Comentario comentarioSave = this.comentarioRepository.save(comentario);
        ComentarioDTOResponse comentarioDTOResponse = new ComentarioDTOResponse();
        comentarioDTOResponse.setId(comentarioSave.getId());
        comentarioDTOResponse.setStatus(comentarioSave.getStatus());
        comentarioDTOResponse.setTexto(comentarioSave.getTexto());
        comentarioDTOResponse.setUsuario(comentarioSave.getUsuario().getId());
        comentarioDTOResponse.setPost(comentarioSave.getPost().getId());
        comentarioDTOResponse.setTopico(comentarioSave.getTopico().getId());
//        ComentarioDTOResponse comentarioDTOResponse = modelMapper.map(comentarioSave, ComentarioDTOResponse.class);
        return comentarioDTOResponse;}

    public ComentarioDTOResponse atualizarComentario(Integer comentarioId, ComentarioDTORequest comentarioDTORequest){
        Comentario comentario = this.listarComentarioPorId(comentarioId);
        if(comentario!=null){
            modelMapper.map(comentarioDTORequest,comentario);
            Comentario comentarioSave = this.comentarioRepository.save(comentario);
            ComentarioDTOResponse comentarioDTOResponse = modelMapper.map(comentarioSave,ComentarioDTOResponse.class);
            return comentarioDTOResponse;
        }
        else {return null;}
    }

    public ComentarioDTOUpdateResponse atualizarStatusComentario(Integer comentarioId, ComentarioDTOUpdateRequest comentarioDTOUpdateRequest) {
        Comentario comentario = this.listarComentarioPorId(comentarioId);
        if (comentario != null) {
            modelMapper.map(comentarioDTOUpdateRequest, comentario);
            Comentario comentarioSave = this.comentarioRepository.save(comentario);

            ComentarioDTOUpdateResponse comentarioDTOUpdateResponse = modelMapper.map(comentarioSave, ComentarioDTOUpdateResponse.class);
            return comentarioDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarComentario(Integer comentarioId){
        this.comentarioRepository.apagarComentario(comentarioId);
    }


}
