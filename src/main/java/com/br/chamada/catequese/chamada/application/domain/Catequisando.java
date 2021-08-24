package com.br.chamada.catequese.chamada.application.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Catequisando {

    private UUID id;
    private String nomeCompleto;
}
