package com.senac.forum_musicos.service;

import com.senac.forum_musicos.entity.Instrumento;
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
}
