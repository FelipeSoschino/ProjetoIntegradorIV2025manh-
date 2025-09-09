package com.senac.forum_musicos.controller;

import com.senac.forum_musicos.DTO.request.UsuarioDTORequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.UsuarioDTOResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOUpdateResponse;
import com.senac.forum_musicos.entity.Usuario;
import com.senac.forum_musicos.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description = "API para gerenciamento de usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Usuarios",description = "end poit para listar todos os usuários")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(this.usuarioService.listarUsuarios());

    }


    @GetMapping("/listarPorUsuarioId/{usuarioId}")
    @Operation(summary = "Listar Usuários pelo Id", description = "End point para listar um usuário dado seu Id")
    public ResponseEntity<Usuario> listarUsuarioId(@PathVariable("usuarioId")Integer usuarioId){
        Usuario usuario = usuarioService.listarUsuarioPorId(usuarioId);
        if (usuario == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(usuario);
    }


    @PostMapping("/criar")
    @Operation(summary = "Criar Usuario", description = "End point para criação de um novo Usuario")
    public ResponseEntity<UsuarioDTOResponse> criarPatroinador(@Valid @RequestBody UsuarioDTORequest usuarioDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.criarUsuario(usuarioDTORequest));
    }

    @PutMapping("/atualizar/{usuarioId}")
    @Operation(summary = "Atualizar Usuario",description = "Endpont para atualizar os dados de um Usuario")
    public ResponseEntity<UsuarioDTOResponse> atualizarUsuario(@PathVariable("usuarioId")Integer usuarioId,
                                                               @RequestBody UsuarioDTORequest usuarioDTORequest){
        return ResponseEntity.ok(this.usuarioService.atualizarUsuario(usuarioId,usuarioDTORequest));
    }

    @PatchMapping("atualizarStatus/{usuarioId}")
    @Operation(summary = "Atualizar Status do Usuario",description = "Endpont para atualizar o status de um Usuario")
    public ResponseEntity<UsuarioDTOUpdateResponse> atualizarStatusUsuario(@PathVariable("usuarioId")Integer usuarioId,
                                                                           @RequestBody UsuarioDTOUpdateRequest usuarioDTOUpdateRequest){
        return ResponseEntity.ok(this.usuarioService.atualizarStatusUsuario(usuarioId,usuarioDTOUpdateRequest));
    }

    @DeleteMapping("Deletar/{usuarioId}")
    @Operation(summary = "Remover usuario", description = "Endpoint para remover um usuario dado seu ID")
    public void apagarUsuario(@PathVariable("usuarioId") Integer usuarioId){
        this.usuarioService.apagarUsuario(usuarioId);
    }


}
