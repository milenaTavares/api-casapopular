package com.casapopular.aplicacao.familia;

import com.casapopular.dominio.familia.pessoa.Pessoa;
import com.casapopular.adaptador.persistencia.FamiliaRepositorio;
import com.casapopular.adaptador.persistencia.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdicionaMembros {

    private final FamiliaRepositorio familiaRepositorio;
    private final PessoaRepositorio pessoaRepositorio;

    @Autowired
    public AdicionaMembros(FamiliaRepositorio familiaRepositorio, PessoaRepositorio pessoaRepositorio) {
        this.familiaRepositorio = familiaRepositorio;
        this.pessoaRepositorio = pessoaRepositorio;
    }

    //REFAZER ESTE MÉTODO
    public void adicionar(Integer familiaId, List<Pessoa> pessoas) {
//        Familia familia = familiaRepository.findById(familiaId).get();
//        familia.adicionarMembros(pessoas);
//        pessoaRepository.saveAll(pessoas);
//        familiaRepository.save(familia);
    }
}
