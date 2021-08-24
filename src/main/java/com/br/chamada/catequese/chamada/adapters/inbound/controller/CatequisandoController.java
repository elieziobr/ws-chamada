package com.br.chamada.catequese.chamada.adapters.inbound.controller;

import com.br.chamada.catequese.chamada.application.domain.Catequisando;
import com.br.chamada.catequese.chamada.application.ports.CatequisandoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/chamadas/catequisandos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatequisandoController {

    @Autowired
    CatequisandoServicePort servicePort;

    @PostMapping()
    public ResponseEntity<Catequisando> salvarCatequisando(@RequestBody Catequisando entity) {
        return new ResponseEntity<>(servicePort.save(entity), HttpStatus.CREATED);
    }

    @PostMapping("/emails")
    public ResponseEntity<String> enviarEmail() {
        servicePort.sendEmail();
        return new ResponseEntity<>("Email enviado com sucesso", HttpStatus.OK);
    }
}
