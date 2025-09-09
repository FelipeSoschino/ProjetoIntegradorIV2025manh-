package com.senac.forum_musicos.service;

import com.senac.forum_musicos.DTO.request.TopicoDTORequest;
import com.senac.forum_musicos.DTO.request.TopicoDTOUpdataRequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTORequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.TopicoDTOResponse;
import com.senac.forum_musicos.DTO.response.TopicoDTOUpdateResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOUpdateResponse;
import com.senac.forum_musicos.entity.Topico;
import com.senac.forum_musicos.entity.Usuario;
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
        return this.topicoRepository.listarTopicos();
    }

    public Topico listarTopicoPorId(Integer topicoId) {
        return this.topicoRepository.listarTopicoPorId(topicoId);
    }


    public TopicoDTOResponse criarTopico(TopicoDTORequest topicoDTORequest){
        Topico topico = modelMapper.map(topicoDTORequest, Topico.class);

        Topico topicoSave = this.topicoRepository.save(topico);
        TopicoDTOResponse topicoDTOResponse = modelMapper.map(topicoSave, TopicoDTOResponse.class);
        return topicoDTOResponse;}

    public TopicoDTOResponse atualizarTopico(Integer topicoId, TopicoDTORequest topicoDTORequest){
        Topico topico = this.listarTopicoPorId(topicoId);
        if(topico!=null){
            modelMapper.map(topicoDTORequest,topico);
            Topico topicoSave = this.topicoRepository.save(topico);
            TopicoDTOResponse topicoDTOResponse = modelMapper.map(topicoSave,TopicoDTOResponse.class);
            return topicoDTOResponse;
        }
        else {return null;}
    }

    public TopicoDTOUpdateResponse atualizarStatusTopico(Integer topicoId, TopicoDTOUpdataRequest topicoDTOUpdateRequest) {
        Topico topico = this.listarTopicoPorId(topicoId);
        if (topico != null) {
            modelMapper.map(topicoDTOUpdateRequest, topico);
            Topico topicoSave = this.topicoRepository.save(topico);

            TopicoDTOUpdateResponse topicoDTOUpdateResponse = modelMapper.map(topicoSave, TopicoDTOUpdateResponse.class);
            return topicoDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarTopico(Integer topicoId){
        this.topicoRepository.apagarTopico(topicoId);
    }
}
