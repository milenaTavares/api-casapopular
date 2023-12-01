package com.casapopular.domain.selecao.criterio;

import com.casapopular.domain.familia.Familia;

public interface CriterioDeSelecao {

    Integer obterPontuacao(Familia familia);
}
