package com.senac.forum_musicos.service;

import com.senac.forum_musicos.DTO.request.ParticipaDTORequest;
import com.senac.forum_musicos.DTO.request.ParticipaDTOUpdateRequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTORequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.ParticipaDTOResponse;
import com.senac.forum_musicos.DTO.response.ParticipaDTOUpdateResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOUpdateResponse;
import com.senac.forum_musicos.entity.Participa;
import com.senac.forum_musicos.entity.Usuario;
import com.senac.forum_musicos.repository.ParticipaRepository;
import com.senac.forum_musicos.repository.TopicoRepository;
import com.senac.forum_musicos.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipaService {

    private ParticipaRepository participaRepository;
    private UsuarioRepository usuarioRepository;
    private TopicoRepository topicoRepository;

    public ParticipaService(ParticipaRepository participaRepository, UsuarioRepository usuarioRepository,TopicoRepository topicoRepository){
        this.participaRepository = participaRepository;
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Participa> listarParticipa(){
        return this.participaRepository.listarParticipas();
    }

    public Participa listarParticipaPorId(Integer participaId){
        return this.participaRepository.listarParticipaPorId(participaId);
    }


    public ParticipaDTOResponse criarParticipa(ParticipaDTORequest participaDTORequest){
        Participa participa = new Participa();
        participa.setStatus(participaDTORequest.getStatus());
        participa.setTopico(topicoRepository.listarTopicoPorId(participaDTORequest.getTopicoId()));
        participa.setUsuario(usuarioRepository.listarUsuarioPorId(participaDTORequest.getUsuarioId()));

        Participa participaSave = this.participaRepository.save(participa);
        ParticipaDTOResponse participaDTOResponse = modelMapper.map(participaSave, ParticipaDTOResponse.class);
        return participaDTOResponse;}

    public ParticipaDTOResponse atualizarParticipa(Integer participaId, ParticipaDTORequest participaDTORequest){
        Participa participa = this.listarParticipaPorId(participaId);
        if(participa!=null){
            modelMapper.map(participaDTORequest,participa);
            Participa participaSave = this.participaRepository.save(participa);
            ParticipaDTOResponse participaDTOResponse = modelMapper.map(participaSave,ParticipaDTOResponse.class);
            return participaDTOResponse;
        }
        else {return null;}
    }

    public ParticipaDTOUpdateResponse atualizarStatusParticipa(Integer participaId, ParticipaDTOUpdateRequest participaDTOUpdateRequest) {
        Participa participa = this.participaRepository.listarParticipaPorId(participaId);
        if (participa != null) {
            modelMapper.map(participaDTOUpdateRequest, participa);
            Participa participaSave = this.participaRepository.save(participa);

            ParticipaDTOUpdateResponse participaDTOUpdateResponse = modelMapper.map(participaSave, ParticipaDTOUpdateResponse.class);
            return participaDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarParticipa(Integer participaId){
        this.participaRepository.apagarParticipa(participaId);
    }
}
