package com.senac.forum_musicos.service;

import com.senac.forum_musicos.DTO.request.InstrumentoDTORequest;
import com.senac.forum_musicos.DTO.request.InstrumentoDTOUpdateRequest;
import com.senac.forum_musicos.DTO.request.PostDTORequest;
import com.senac.forum_musicos.DTO.request.PostDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.InstrumentoDTOResponse;
import com.senac.forum_musicos.DTO.response.InstrumentoDTOUpdateResponse;
import com.senac.forum_musicos.DTO.response.PostDTOResponse;
import com.senac.forum_musicos.DTO.response.PostDTOUpdateResponse;
import com.senac.forum_musicos.entity.Instrumento;
import com.senac.forum_musicos.entity.Post;
import com.senac.forum_musicos.repository.InstrumentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentoService {

    private InstrumentoRepository instrumentoRepository;

    public InstrumentoService(InstrumentoRepository instrumentoRepository){
        this.instrumentoRepository = instrumentoRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Instrumento> listarInstrumentos(){
        return this.instrumentoRepository.findAll();
    }

    public Instrumento listarInstrumentoPorId(Integer instrumentoId){
        return this.instrumentoRepository.findById(instrumentoId).orElse(null);
    }


    public InstrumentoDTOResponse criarInstrumento(InstrumentoDTORequest instrumentoDTORequest){
        Instrumento instrumento = modelMapper.map(instrumentoDTORequest, Instrumento.class);

        Instrumento instrumentoSave = this.instrumentoRepository.save(instrumento);
        InstrumentoDTOResponse instrumentoDTOResponse = modelMapper.map(instrumentoSave, InstrumentoDTOResponse.class);
        return instrumentoDTOResponse;}

    public InstrumentoDTOResponse atualizarInstrumento(Integer instrumentoId, InstrumentoDTORequest instrumentoDTORequest){
        Instrumento instrumento = this.listarInstrumentoPorId(instrumentoId);
        if(instrumento!=null){
            modelMapper.map(instrumentoDTORequest,instrumento);
            Instrumento instrumentoSave = this.instrumentoRepository.save(instrumento);
            InstrumentoDTOResponse instrumentoDTOResponse = modelMapper.map(instrumentoSave,InstrumentoDTOResponse.class);
            return instrumentoDTOResponse;
        }
        else {return null;}
    }

    public InstrumentoDTOUpdateResponse atualizarStatusInstrumento(Integer instrumentoId, InstrumentoDTOUpdateRequest instrumentoDTOUpdateRequest) {
        Instrumento instrumento = this.listarInstrumentoPorId(instrumentoId);
        if (instrumento != null) {
            modelMapper.map(instrumentoDTOUpdateRequest, instrumento);
            Instrumento instrumentoSave = this.instrumentoRepository.save(instrumento);

            InstrumentoDTOUpdateResponse instrumentoDTOUpdateResponse = modelMapper.map(instrumentoSave, InstrumentoDTOUpdateResponse.class);
            return instrumentoDTOUpdateResponse;
        } else
            return null;
    }

//    public void apagarInstrumento(Integer instrumentoId){
//        this.instrumentoRepository.apagarInstrumento(instrumentoId);
//    }
}
