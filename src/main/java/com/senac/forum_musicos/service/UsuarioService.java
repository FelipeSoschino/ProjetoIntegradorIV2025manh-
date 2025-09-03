package com.senac.forum_musicos.service;

import com.senac.forum_musicos.entity.Usuario;
import com.senac.forum_musicos.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario listarUsuarioPorId(Integer usuarioId){
        return this.usuarioRepository.findById(usuarioId).orElse(null);
    }
}
