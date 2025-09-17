package com.senac.forum_musicos.controller;

import com.senac.forum_musicos.DTO.request.ComentarioDTORequest;
import com.senac.forum_musicos.DTO.request.ComentarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.request.PostDTORequest;
import com.senac.forum_musicos.DTO.request.PostDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.ComentarioDTOResponse;
import com.senac.forum_musicos.DTO.response.ComentarioDTOUpdateResponse;
import com.senac.forum_musicos.DTO.response.PostDTOResponse;
import com.senac.forum_musicos.DTO.response.PostDTOUpdateResponse;
import com.senac.forum_musicos.entity.Comentario;
import com.senac.forum_musicos.entity.Post;
import com.senac.forum_musicos.service.ComentarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comentario")
@Tag(name="Comentario",description = "API para gerenciar comentários")
public class ComentarioController {

    private ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService){
        this.comentarioService = comentarioService;
    }
    
    @GetMapping("/listar")
    @Operation(summary = "Listar Comentarios",description = "end poit para listar todos os usuários")
    public ResponseEntity<List<Comentario>> listarComentarios(){
        return ResponseEntity.ok(this.comentarioService.listarComentarios());

    }
    @GetMapping("/listarPorComentarioId/{comentarioId}")
    @Operation(summary = "Listar Comentarios pelo Id", description = "End point para listar um comentarios dado seu Id")
    public ResponseEntity<Comentario> listarComentarioId(@PathVariable("comentarioId")Integer comentarioId){
        Comentario comentario = comentarioService.listarComentarioPorId(comentarioId);
        if (comentario == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(comentario);
    }

    @PostMapping("/criarComentario")
    @Operation(summary = "Criar Comentario",description = "End point para criação de um comentario")
    public ResponseEntity<ComentarioDTOResponse> criarComentario(@Valid @RequestBody ComentarioDTORequest comentarioDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.comentarioService.criarComentario(comentarioDTORequest));
    }

    @PutMapping("/atualizarComentario/{comentarioId}")
    @Operation(summary = "Atualizar Tópico", description = "End point para atualizar um tópico já existente")
    public ResponseEntity<ComentarioDTOResponse> atualizarComentario(@PathVariable("comentarioId")Integer comentarioId, @RequestBody ComentarioDTORequest comentarioDTORequest){
        Comentario comentario = comentarioService.listarComentarioPorId(comentarioId);
        if(comentario!= null){
            return ResponseEntity.ok(this.comentarioService.atualizarComentario(comentarioId,comentarioDTORequest));
        }
        else
            return ResponseEntity.noContent().build();

    }

    @PatchMapping("/atualizarStatusComentario/{comentarioId}")
    @Operation(summary = "Atualizar Status do Tópico", description = "End point para atualizar o status de um tópico já existente")
    public ResponseEntity<ComentarioDTOUpdateResponse> atualizarComentarioStatus(@PathVariable("comentarioId")Integer comentarioId,
                                                                                 @RequestBody ComentarioDTOUpdateRequest comentarioDTORequest){
        return ResponseEntity.ok(this.comentarioService.atualizarStatusComentario(comentarioId,comentarioDTORequest));}

    @DeleteMapping("Deletar/{comentarioId}")
    @Operation(summary = "Remover comentario", description = "Endpoint para remover um comentario dado seu ID")
    public void apagarComentario(@PathVariable("comentarioId") Integer comentarioId){
        this.comentarioService.apagarComentario(comentarioId);
    }


}
