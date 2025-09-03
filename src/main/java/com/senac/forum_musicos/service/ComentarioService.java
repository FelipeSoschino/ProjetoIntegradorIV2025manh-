package com.senac.forum_musicos.service;

import com.senac.forum_musicos.entity.Comentario;
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
        return this.comentarioRepository.findAll();
    }

    public Comentario listarComentarioPorId(Integer cometarioId){
        return this.comentarioRepository.findById(cometarioId).orElse(null);

    }


}
