package com.senac.forum_musicos.service;

import com.senac.forum_musicos.DTO.request.UsuarioDTORequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.UsuarioDTOResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOUpdateResponse;
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
        return this.usuarioRepository.listarUsuarios();
    }

    public Usuario listarUsuarioPorId(Integer usuarioId){
        return this.usuarioRepository.listarUsuarioPorId(usuarioId);
    }

    public UsuarioDTOResponse criarUsuario(UsuarioDTORequest usuarioDTORequest){
        Usuario usuario = modelMapper.map(usuarioDTORequest, Usuario.class);

        Usuario usuarioSave = this.usuarioRepository.save(usuario);
        UsuarioDTOResponse usuarioDTOResponse = modelMapper.map(usuarioSave, UsuarioDTOResponse.class);
        return usuarioDTOResponse;}

    public UsuarioDTOResponse atualizarUsuario(Integer usuarioId, UsuarioDTORequest usuarioDTORequest){
        Usuario usuario = this.listarUsuarioPorId(usuarioId);
        if(usuario!=null){
            modelMapper.map(usuarioDTORequest,usuario);
            Usuario usuarioSave = this.usuarioRepository.save(usuario);
            UsuarioDTOResponse usuarioDTOResponse = modelMapper.map(usuarioSave,UsuarioDTOResponse.class);
            return usuarioDTOResponse;
        }
        else {return null;}
    }

    public UsuarioDTOUpdateResponse atualizarStatusUsuario(Integer usuarioId, UsuarioDTOUpdateRequest usuarioDTOUpdateRequest) {
        Usuario usuario = this.listarUsuarioPorId(usuarioId);
        if (usuario != null) {
            modelMapper.map(usuarioDTOUpdateRequest, usuario);
            Usuario usuarioSave = this.usuarioRepository.save(usuario);

            UsuarioDTOUpdateResponse usuarioDTOUpdateResponse = modelMapper.map(usuarioSave, UsuarioDTOUpdateResponse.class);
            return usuarioDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarUsuario(Integer usuarioId){
        this.usuarioRepository.apagarUsuario(usuarioId);
    }
}





