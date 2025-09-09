package com.senac.forum_musicos.service;

import com.senac.forum_musicos.DTO.request.CurtidaDTORequest;
import com.senac.forum_musicos.DTO.request.CurtidaDTOUpdateRequest;
import com.senac.forum_musicos.DTO.request.ParticipaDTORequest;
import com.senac.forum_musicos.DTO.request.ParticipaDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.CurtidaDTOResponse;
import com.senac.forum_musicos.DTO.response.CurtidaDTOUpdateResponse;
import com.senac.forum_musicos.DTO.response.ParticipaDTOResponse;
import com.senac.forum_musicos.DTO.response.ParticipaDTOUpdateResponse;
import com.senac.forum_musicos.entity.Curtida;
import com.senac.forum_musicos.entity.Participa;
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

    public CurtidaDTOResponse criarCurtida(CurtidaDTORequest curtidaDTORequest){
        Curtida curtida = modelMapper.map(curtidaDTORequest, Curtida.class);

        Curtida curtidaSave = this.curtidaRepository.save(curtida);
        CurtidaDTOResponse curtidaDTOResponse = modelMapper.map(curtidaSave, CurtidaDTOResponse.class);
        return curtidaDTOResponse;}

    public CurtidaDTOResponse atualizarCurtida(Integer curtidaId, CurtidaDTORequest curtidaDTORequest){
        Curtida curtida = this.listarCurtidaPorId(curtidaId);
        if(curtida!=null){
            modelMapper.map(curtidaDTORequest,curtida);
            Curtida curtidaSave = this.curtidaRepository.save(curtida);
            CurtidaDTOResponse curtidaDTOResponse = modelMapper.map(curtidaSave,CurtidaDTOResponse.class);
            return curtidaDTOResponse;
        }
        else {return null;}
    }

    public CurtidaDTOUpdateResponse atualizarStatusCurtida(Integer curtidaId, CurtidaDTOUpdateRequest curtidaDTOUpdateRequest) {
        Curtida curtida = this.listarCurtidaPorId(curtidaId);
        if (curtida != null) {
            modelMapper.map(curtidaDTOUpdateRequest, curtida);
            Curtida curtidaSave = this.curtidaRepository.save(curtida);

            CurtidaDTOUpdateResponse curtidaDTOUpdateResponse = modelMapper.map(curtidaSave, CurtidaDTOUpdateResponse.class);
            return curtidaDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarCurtida(Integer curtidaId){
        this.curtidaRepository.apagarCurtida(curtidaId);}
}
