package com.senac.forum_musicos.service;

import com.senac.forum_musicos.entity.Participa;
import com.senac.forum_musicos.repository.ParticipaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipaService {

    private ParticipaRepository participaRepository;

    public ParticipaService(ParticipaRepository participaRepository){
        this.participaRepository = participaRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Participa> listarParticipa(){
        return this.participaRepository.findAll();
    }
}
