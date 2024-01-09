package com.casapopular.dominio.selecao;

import lombok.Getter;

@Getter
public class FamiliaPontuada {

    private Integer familiaId;
    private Integer pontuacao;

    public FamiliaPontuada(Integer familiaId, Integer pontuacao) {
        this.familiaId = familiaId;
        this.pontuacao = pontuacao;
    }
}
