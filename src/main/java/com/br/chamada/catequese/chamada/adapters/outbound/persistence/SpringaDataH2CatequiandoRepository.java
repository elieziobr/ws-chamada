package com.br.chamada.catequese.chamada.adapters.outbound.persistence;

import com.br.chamada.catequese.chamada.adapters.outbound.persistence.entities.CatequisandoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringaDataH2CatequiandoRepository extends JpaRepository<CatequisandoEntity, UUID> {
}
