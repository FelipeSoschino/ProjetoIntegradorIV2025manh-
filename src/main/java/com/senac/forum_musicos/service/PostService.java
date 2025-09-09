package com.senac.forum_musicos.service;

import com.senac.forum_musicos.DTO.request.PostDTORequest;
import com.senac.forum_musicos.DTO.request.PostDTOUpdateRequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTORequest;
import com.senac.forum_musicos.DTO.request.UsuarioDTOUpdateRequest;
import com.senac.forum_musicos.DTO.response.PostDTOResponse;
import com.senac.forum_musicos.DTO.response.PostDTOUpdateResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOResponse;
import com.senac.forum_musicos.DTO.response.UsuarioDTOUpdateResponse;
import com.senac.forum_musicos.entity.Post;
import com.senac.forum_musicos.entity.Usuario;
import com.senac.forum_musicos.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    public List<Post> listarPosts(){
        return this.postRepository.listarPosts();
    }
    public Post listarPostPorId(Integer postId){
        return this.postRepository.listarPostPorId(postId);
    }


    public PostDTOResponse criarPost(PostDTORequest postDTORequest){
        Post post = modelMapper.map(postDTORequest, Post.class);

        Post postSave = this.postRepository.save(post);
        PostDTOResponse postDTOResponse = modelMapper.map(postSave, PostDTOResponse.class);
        return postDTOResponse;}

    public PostDTOResponse atualizarPost(Integer postId, PostDTORequest postDTORequest){
        Post post = this.listarPostPorId(postId);
        if(post!=null){
            modelMapper.map(postDTORequest,post);
            Post postSave = this.postRepository.save(post);
            PostDTOResponse postDTOResponse = modelMapper.map(postSave,PostDTOResponse.class);
            return postDTOResponse;
        }
        else {return null;}
    }

    public PostDTOUpdateResponse atualizarStatusPost(Integer postId, PostDTOUpdateRequest postDTOUpdateRequest) {
        Post post = this.listarPostPorId(postId);
        if (post != null) {
            modelMapper.map(postDTOUpdateRequest, post);
            Post postSave = this.postRepository.save(post);

            PostDTOUpdateResponse postDTOUpdateResponse = modelMapper.map(postSave, PostDTOUpdateResponse.class);
            return postDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarPost(Integer postId){
        this.postRepository.apagarPost(postId);
    }
}
    
