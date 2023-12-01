package com.casapopular.service.familia;

import com.casapopular.domain.Pessoa;
import com.casapopular.repository.FamiliaRepository;
import com.casapopular.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdicionaMembros {

    private final FamiliaRepository familiaRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public AdicionaMembros(FamiliaRepository familiaRepository, PessoaRepository pessoaRepository) {
        this.familiaRepository = familiaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    //REFAZER ESTE MÉTODO
    public void adicionar(Integer familiaId, List<Pessoa> pessoas) {
//        Familia familia = familiaRepository.findById(familiaId).get();
//        familia.adicionarMembros(pessoas);
//        pessoaRepository.saveAll(pessoas);
//        familiaRepository.save(familia);
    }
}
