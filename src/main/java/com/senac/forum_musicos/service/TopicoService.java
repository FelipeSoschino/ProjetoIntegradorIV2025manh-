package com.senac.forum_musicos.service;

import com.senac.forum_musicos.entity.Topico;
import com.senac.forum_musicos.repository.TopicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    public List<Topico> listarTopicos(){
        return this.topicoRepository.findAll();
    }

    public Topico listarTopicoPorId(Integer topicoId){
        return this.topicoRepository.findById(topicoId).orElse(null);
    }
}
