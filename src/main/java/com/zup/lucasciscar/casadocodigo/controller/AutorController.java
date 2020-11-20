package com.zup.lucasciscar.casadocodigo.controller;

import com.zup.lucasciscar.casadocodigo.dto.AutorRequest;
import com.zup.lucasciscar.casadocodigo.entity.Autor;
import com.zup.lucasciscar.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AutorController {

    private final AutorRepository autorRepository;

    AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/autor")
    public ResponseEntity<?> salvarAutor(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.paraAutor();
        autorRepository.save(autor);

        return ResponseEntity.ok(autor);
    }

}
