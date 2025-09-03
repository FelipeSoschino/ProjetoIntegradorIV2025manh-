package com.senac.forum_musicos.service;

import com.senac.forum_musicos.entity.Post;
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
        return this.postRepository.findAll();
    }
    public Post listarPostPorId(Integer postId){
        return this.postRepository.findById(postId).orElse(null);
    }
}
