package com.zup.lucasciscar.casadocodigo.repository;

import com.zup.lucasciscar.casadocodigo.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

    Optional<Autor> findByEmail(String email);

}
