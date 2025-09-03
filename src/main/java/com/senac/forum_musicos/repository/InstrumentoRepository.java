package com.senac.forum_musicos.repository;

import com.senac.forum_musicos.entity.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer> {
}
