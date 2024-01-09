package com.casapopular.aplicacao.familia;

import com.casapopular.adaptador.persistencia.FamiliaRepositorio;
import com.casapopular.adaptador.persistencia.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluiMembro {

    private final FamiliaRepositorio familiaRepositorio;
    private final PessoaRepositorio pessoaRepositorio;

    @Autowired
    public ExcluiMembro(FamiliaRepositorio familiaRepositorio, PessoaRepositorio pessoaRepositorio) {
        this.familiaRepositorio = familiaRepositorio;
        this.pessoaRepositorio = pessoaRepositorio;
    }

    //REFAZER ESTE MÉTODO
    public void excluir(Integer familiaId, Integer membroId) {
//        Familia familia = familiaRepository.findById(familiaId).get();
//        familia.excluirMembro(membroId);
//        familiaRepository.save(familia);
//        pessoaRepository.deleteById(membroId);
    }
}
