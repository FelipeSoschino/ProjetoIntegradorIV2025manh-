package com.senac.forum_musicos.controller;

import com.senac.forum_musicos.DTO.request.ParticipaDTORequest;
import com.senac.forum_musicos.DTO.request.ParticipaDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.ParticipaDTOResponse;
import com.senac.forum_musicos.DTO.response.ParticipaDTOUpdateResponse;
import com.senac.forum_musicos.entity.Participa;
import com.senac.forum_musicos.service.ParticipaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/participa")
@Tag(name = "Participa", description = "Api para gerenciar participantes dos tópicos")
public class ParticipaController {

    private ParticipaService participaService;

    public ParticipaController(ParticipaService participaService){
        this.participaService = participaService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Participantes", description = "End point para listar todos os participantes de um topico")
    public ResponseEntity<List<Participa>> listarParticipantes(){
        return ResponseEntity.ok(participaService.listarParticipa());
    }

    @PostMapping("/criarParticipa")
    @Operation(summary = "Criar Participantes", description = "End point para criar participantes de um topico")
    public ResponseEntity<ParticipaDTOResponse> criarParticipa(@Valid @RequestBody ParticipaDTORequest participaDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.participaService.criarParticipa(participaDTORequest));
    }

    @PatchMapping("atualizaStatusParticipa/{participaId}")
    @Operation(summary = "Atualizar Participa status", description = "End point para atualizar status da participacao")
    public ResponseEntity<ParticipaDTOUpdateResponse> atualizarStatusParticipa(@PathVariable("participaId")Integer participaId,
                                                                               @RequestBody ParticipaDTOUpdateRequest participaDTOUpdateRequest){
        return ResponseEntity.ok(this.participaService.atualizarStatusParticipa(participaId,participaDTOUpdateRequest));

    }

    @DeleteMapping("deletar/{participaId}")
    @Operation(summary = "Deletar Participacao", description = "End point para deletar uma participacao de um membro")
    public void apagarParticipa(@PathVariable("participaId") Integer participaId){
        this.participaService.apagarParticipa(participaId);
    }
}
