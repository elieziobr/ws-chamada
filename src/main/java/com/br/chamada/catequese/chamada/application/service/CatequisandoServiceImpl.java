package com.br.chamada.catequese.chamada.application.service;

import com.br.chamada.catequese.chamada.application.domain.Catequisando;
import com.br.chamada.catequese.chamada.application.domain.Email;
import com.br.chamada.catequese.chamada.application.domain.PageInfo;
import com.br.chamada.catequese.chamada.application.domain.enums.StatusEmail;
import com.br.chamada.catequese.chamada.application.ports.CatequisandoRepositoryPort;
import com.br.chamada.catequese.chamada.application.ports.CatequisandoServicePort;
import com.br.chamada.catequese.chamada.application.ports.SendEmailServicePort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CatequisandoServiceImpl implements CatequisandoServicePort {

    private final CatequisandoRepositoryPort catequisandoRepositoryPort;
    private final SendEmailServicePort sendEmailServicePort;

    public CatequisandoServiceImpl(final CatequisandoRepositoryPort catequisandoRepositoryPort,
                                   final SendEmailServicePort sendEmailServicePort) {
        this.catequisandoRepositoryPort = catequisandoRepositoryPort;
        this.sendEmailServicePort = sendEmailServicePort;
    }

    @Override
    public void sendEmail() {
        Email email = new Email();

        findAll().stream().forEach(catequisando -> obterDados(email, catequisando));

        email.setSendDateEmail(LocalDateTime.now());
        email.setEmailFrom("elieziobr@gmail.com");
        email.setEmailTo("elieziobr@gmail.com");
        email.setSubject("Chamada Turma:" + email.getSendDateEmail());
        email.setOwnerRef("Prezados Catequista, segue lista da chamada");

        try {
            sendEmailServicePort.sendEmailSmtp(email);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (Exception e) {
            e.getStackTrace();
            email.setStatusEmail(StatusEmail.ERROR);
        }
    }

    private void obterDados(Email email, Catequisando catequisando) {
        email.setText(email.getText() + "\r\n" + catequisando.getNomeCompleto());
    }

    @Override
    public List<Catequisando> findAll(PageInfo pageInfo) {
        return catequisandoRepositoryPort.findAll(pageInfo);
    }

    @Override
    public List<Catequisando> findAll() {
        return catequisandoRepositoryPort.findAll();
    }

    @Override
    public Optional<Catequisando> findById(UUID catequisandoid) {
        return catequisandoRepositoryPort.findById(catequisandoid);
    }

    @Override
    public Catequisando save(Catequisando catequisando) {
        return catequisandoRepositoryPort.save(catequisando);
    }
}
