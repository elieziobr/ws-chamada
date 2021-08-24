package com.br.chamada.catequese.chamada.adapters.outbound.persistence;

import com.br.chamada.catequese.chamada.adapters.outbound.persistence.SpringaDataH2CatequiandoRepository;
import com.br.chamada.catequese.chamada.adapters.outbound.persistence.entities.CatequisandoEntity;
import com.br.chamada.catequese.chamada.application.domain.Catequisando;
import com.br.chamada.catequese.chamada.application.domain.PageInfo;
import com.br.chamada.catequese.chamada.application.ports.CatequisandoRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class CatequisandoRepository implements CatequisandoRepositoryPort {

    private final SpringaDataH2CatequiandoRepository repository;
    public CatequisandoRepository(final SpringaDataH2CatequiandoRepository repository) {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Catequisando save(Catequisando catequisando) {
        CatequisandoEntity entity = repository.save(modelMapper.map(catequisando, CatequisandoEntity.class));
        return modelMapper.map(entity, Catequisando.class);
    }

    @Override
    public List<Catequisando> findAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public List<Catequisando> findAll() {
        return repository.findAll().stream().map(entity -> modelMapper.map(entity, Catequisando.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Catequisando> findById(UUID catequisandoId) {
        return Optional.empty();
    }
}
