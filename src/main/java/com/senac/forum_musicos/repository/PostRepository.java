package com.senac.forum_musicos.repository;

import com.senac.forum_musicos.entity.Post;
import com.senac.forum_musicos.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.status = -1 where p.id = :id")
    void apagarPost(Integer postId);

    @Query("SELECT p FROM Post p where p.status >= 0")
    List<Post> listarPosts();
    @Query("SELECT p FROM Post p where p.status >= 0 AND p.id = :id")
    Post listarPostPorId(@Param("id") Integer postId);

    @Query("SELECT p FROM Post p where p.status >=0 and p.usuario.id = :usuarioId")
    List<Post> listarPostsUsuadio(@Param("usuarioId")Integer usuarioId);
}
