package com.casapopular.aplicacao.familia;

import com.casapopular.adaptador.persistencia.FamiliaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluiFamilia {

    private final FamiliaRepositorio familiaRepositorio;

    @Autowired
    public ExcluiFamilia(FamiliaRepositorio familiaRepositorio) {
        this.familiaRepositorio = familiaRepositorio;
    }

    public void excluir(Integer familiaId) {
        familiaRepositorio.deleteById(familiaId);
    }
}
