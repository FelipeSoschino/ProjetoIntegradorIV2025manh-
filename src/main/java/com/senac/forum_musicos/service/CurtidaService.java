package com.senac.forum_musicos.service;

import com.senac.forum_musicos.entity.Curtida;
import com.senac.forum_musicos.repository.CurtidaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurtidaService {

    private CurtidaRepository curtidaRepository;

    public CurtidaService(CurtidaRepository curtidaRepository){
        this.curtidaRepository = curtidaRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Curtida> listarCurtidas(){
        return this.curtidaRepository.findAll();
    }
    public Curtida listarCurtidaPorId(Integer curtidaId){
        return this.curtidaRepository.findById(curtidaId).orElse(null);
    }
}
