package com.zup.lucasciscar.casadocodigo.repository;

import com.zup.lucasciscar.casadocodigo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);

}
