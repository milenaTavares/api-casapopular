package com.casapopular.aplicacao.familia;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.adaptador.persistencia.FamiliaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionaFamilia {

    private final FamiliaRepositorio familiaRepositorio;

    @Autowired
    public AdicionaFamilia(FamiliaRepositorio familiaRepositorio) {
        this.familiaRepositorio = familiaRepositorio;
    }

    public Integer adicionar(Familia familia) {
        Familia familiaAdicionada = familiaRepositorio.save(familia);
        return familiaAdicionada.getId();
    }
}
