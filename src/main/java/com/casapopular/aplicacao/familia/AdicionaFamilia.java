package com.casapopular.aplicacao.familia;

import com.casapopular.adaptador.controlador.FamiliaEntrada;
import com.casapopular.adaptador.persistencia.FamiliaRepositorio;
import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.familia.pessoa.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdicionaFamilia {

    private final FamiliaRepositorio familiaRepositorio;

    @Autowired
    public AdicionaFamilia(FamiliaRepositorio familiaRepositorio) {
        this.familiaRepositorio = familiaRepositorio;
    }

    public Integer adicionar(FamiliaEntrada familia) {
        Familia familiaAdicionada = familiaRepositorio.save(montarFamilia(familia));
        return familiaAdicionada.getId();
    }

    private Familia montarFamilia(FamiliaEntrada familiaEntrada) {
        List<Pessoa> membrosDaFamilia = familiaEntrada.membros.stream()
                .map(membro -> new Pessoa(membro.nome, membro.dataDeNascimento, membro.renda))
                .toList();
        return new Familia(membrosDaFamilia);
    }
}
