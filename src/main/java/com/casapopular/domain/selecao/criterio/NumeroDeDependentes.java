package com.casapopular.domain.selecao.criterio;

import com.casapopular.domain.familia.Familia;

public class NumeroDeDependentes implements CriterioDeSelecao {

    @Override
    public Integer obterPontuacao(Familia familia) {
        Integer pontos = 0;
        Integer numeroDeDependentes = familia.obterQuantidadeDeMembrosMaioresDeIdade();
        if (numeroDeDependentes >= 3)
            pontos = 3;
        else
            pontos = 2;

        return pontos;
    }
}
