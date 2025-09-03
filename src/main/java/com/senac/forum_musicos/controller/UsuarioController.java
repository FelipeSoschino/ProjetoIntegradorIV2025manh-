package com.senac.forum_musicos.controller;

import com.senac.forum_musicos.entity.Usuario;
import com.senac.forum_musicos.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
