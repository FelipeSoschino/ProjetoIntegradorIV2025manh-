package com.senac.forum_musicos.controller;

import com.senac.forum_musicos.DTO.request.PostDTORequest;
import com.senac.forum_musicos.DTO.request.PostDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.PostDTOResponse;
import com.senac.forum_musicos.DTO.response.PostDTOUpdateResponse;
import com.senac.forum_musicos.entity.Post;
import com.senac.forum_musicos.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
@Tag(name="Post", description = "API para gerenciamento de postagens")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Posts",description = "end poit para listar todos os usuários")
    public ResponseEntity<List<Post>> listarPosts(){
        return ResponseEntity.ok(this.postService.listarPosts());

    }
    @GetMapping("/listarPorPostId/{postId}")
    @Operation(summary = "Listar Posts pelo Id", description = "End point para listar um posts dado seu Id")
    public ResponseEntity<Post> listarPostId(@PathVariable("postId")Integer postId){
        Post post = postService.listarPostPorId(postId);
        if (post == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(post);
    }

    @GetMapping("/listarPorUsuarioId/{usuarioId}")
    @Operation(summary = "Listar Posts pelo Id de um Usuário", description = "End point para listar uma lista de posts de um usuário dado seu Id")
    public ResponseEntity<List<Post>> listarPostsPorUsuarioId(@PathVariable("usuarioId")Integer usuarioId){
       List<Post> listaPosts = postService.listarPostsUsuario(usuarioId);
       if(listaPosts ==null)
           return ResponseEntity.noContent().build();
       else
           return ResponseEntity.ok(listaPosts);
    }

    @PostMapping("/criarPost")
    @Operation(summary = "Criar Post",description = "End point para criação de um post")
    public ResponseEntity<PostDTOResponse> criarPost(@Valid @RequestBody PostDTORequest postDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.postService.criarPost(postDTORequest));
    }

    @PutMapping("/atualizarPost/{postId}")
    @Operation(summary = "Atualizar Tópico", description = "End point para atualizar um tópico já existente")
    public ResponseEntity<PostDTOResponse> atualizarPost(@PathVariable("postId")Integer postId, @RequestBody PostDTORequest postDTORequest){
        Post post = postService.listarPostPorId(postId);
        if(post!= null){
            return ResponseEntity.ok(this.postService.atualizarPost(postId,postDTORequest));
        }
        else
            return ResponseEntity.noContent().build();

    }

    @PatchMapping("/atualizarStatusPost/{postId}")
    @Operation(summary = "Atualizar Status do Tópico", description = "End point para atualizar o status de um tópico já existente")
    public ResponseEntity<PostDTOUpdateResponse> atualizarPostStatus(@PathVariable("postId")Integer postId,
                                                                     @RequestBody PostDTOUpdateRequest postDTORequest){
        return ResponseEntity.ok(this.postService.atualizarStatusPost(postId,postDTORequest));}

    @DeleteMapping("Deletar/{postId}")
    @Operation(summary = "Remover post", description = "Endpoint para remover um post dado seu ID")
    public void apagarPost(@PathVariable("postId") Integer postId){
        this.postService.apagarPost(postId);
    }




}
