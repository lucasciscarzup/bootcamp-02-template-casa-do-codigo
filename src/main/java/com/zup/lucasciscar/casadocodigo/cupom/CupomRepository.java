package com.zup.lucasciscar.casadocodigo.cupom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom, Long> {

    Cupom findByCodigo(String codigo);

}
