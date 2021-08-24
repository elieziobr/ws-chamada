package com.br.chamada.catequese.chamada.application.ports;

import com.br.chamada.catequese.chamada.application.domain.Catequisando;
import com.br.chamada.catequese.chamada.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CatequisandoServicePort {
    void sendEmail();
    List<Catequisando> findAll(PageInfo pageInfo);
    List<Catequisando> findAll();
    Optional<Catequisando> findById(UUID catequisandoid);
    Catequisando save(Catequisando catequisando);
}
