package com.zup.lucasciscar.casadocodigo.repository;

import com.zup.lucasciscar.casadocodigo.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
