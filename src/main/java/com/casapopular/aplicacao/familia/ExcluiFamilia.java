package com.casapopular.aplicacao.familia;

import com.casapopular.adaptador.repositorio.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluiFamilia {

    private final FamiliaRepository familiaRepository;

    @Autowired
    public ExcluiFamilia(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    public void excluir(Integer familiaId) {
        familiaRepository.deleteById(familiaId);
    }
}
