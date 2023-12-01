package com.casapopular.service.familia;

import com.casapopular.repository.FamiliaRepository;
import com.casapopular.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluiMembro {

    private final FamiliaRepository familiaRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public ExcluiMembro(FamiliaRepository familiaRepository, PessoaRepository pessoaRepository) {
        this.familiaRepository = familiaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    //REFAZER ESTE MÉTODO
    public void excluir(Integer familiaId, Integer membroId) {
//        Familia familia = familiaRepository.findById(familiaId).get();
//        familia.excluirMembro(membroId);
//        familiaRepository.save(familia);
//        pessoaRepository.deleteById(membroId);
    }
}
