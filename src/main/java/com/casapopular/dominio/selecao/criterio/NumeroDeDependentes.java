package com.casapopular.dominio.selecao.criterio;

import com.casapopular.dominio.familia.Familia;

public class NumeroDeDependentes implements CriterioDeSelecao {

    @Override
    public Integer obterPontuacao(Familia familia) {
        int pontos;
        Integer numeroDeDependentes = familia.obterQuantidadeDeMembrosMaioresDeIdade();
        if (numeroDeDependentes >= 3)
            pontos = 3;
        else
            pontos = 2;

        return pontos;
    }
}
