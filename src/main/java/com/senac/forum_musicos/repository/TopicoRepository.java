package com.senac.forum_musicos.repository;

import com.senac.forum_musicos.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer> {
}
