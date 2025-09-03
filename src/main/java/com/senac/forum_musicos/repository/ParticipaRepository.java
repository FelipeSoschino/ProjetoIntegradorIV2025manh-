package com.senac.forum_musicos.repository;

import com.senac.forum_musicos.entity.Participa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipaRepository extends JpaRepository<Participa, Integer> {
}
