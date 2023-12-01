package com.casapopular.service.familia;

import com.casapopular.repository.FamiliaRepository;
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
