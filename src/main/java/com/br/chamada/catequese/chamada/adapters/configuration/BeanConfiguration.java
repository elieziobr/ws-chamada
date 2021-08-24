package com.br.chamada.catequese.chamada.adapters.configuration;

import com.br.chamada.catequese.chamada.ChamadaApplication;
import com.br.chamada.catequese.chamada.application.ports.CatequisandoRepositoryPort;
import com.br.chamada.catequese.chamada.application.ports.SendEmailServicePort;
import com.br.chamada.catequese.chamada.application.service.CatequisandoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ChamadaApplication.class)
public class BeanConfiguration {

    @Bean
    CatequisandoServiceImpl catequisandoService(CatequisandoRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
        return new CatequisandoServiceImpl(repository, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
