package com.casapopular.aplicacao.familia;

import com.casapopular.dominio.familia.pessoa.Pessoa;
import com.casapopular.adaptador.repositorio.FamiliaRepository;
import com.casapopular.adaptador.repositorio.PessoaRepository;
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
