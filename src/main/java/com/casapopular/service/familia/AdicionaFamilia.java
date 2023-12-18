package com.casapopular.service.familia;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionaFamilia {

    private final FamiliaRepository familiaRepository;

    @Autowired
    public AdicionaFamilia(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    public Integer adicionar(Familia familia) {
        Familia familiaAdicionada = familiaRepository.save(familia);
        return familiaAdicionada.getId();
    }
}
