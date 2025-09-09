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
import com.senac.forum_musicos.entity.Usuario;
import com.senac.forum_musicos.repository.ComentarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private ComentarioRepository comentarioRepository;

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
        Comentario comentario = modelMapper.map(comentarioDTORequest, Comentario.class);

        Comentario comentarioSave = this.comentarioRepository.save(comentario);
        ComentarioDTOResponse comentarioDTOResponse = modelMapper.map(comentarioSave, ComentarioDTOResponse.class);
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
