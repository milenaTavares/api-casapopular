package com.casapopular.dominio.selecao.criterio;

import com.casapopular.dominio.familia.Familia;

public class RendaTotal implements CriterioDeSelecao {

    @Override
    public Integer obterPontuacao(Familia familia) {
        int pontos = 0;
        Double rendaTotal = familia.obterRendaTotal();
        if (rendaTotal <= 900.0)
            pontos = 5;
        else if (901.0 <= rendaTotal && rendaTotal <= 1500.0)
            pontos = 3;

        return pontos;
    }
}
