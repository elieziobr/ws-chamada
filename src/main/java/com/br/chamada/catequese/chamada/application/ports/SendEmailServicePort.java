package com.br.chamada.catequese.chamada.application.ports;

import com.br.chamada.catequese.chamada.application.domain.Email;

public interface SendEmailServicePort {
    void sendEmailSmtp(Email email);
}
