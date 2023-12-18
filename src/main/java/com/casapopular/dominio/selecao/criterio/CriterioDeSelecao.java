package com.casapopular.dominio.selecao.criterio;

import com.casapopular.dominio.familia.Familia;

public interface CriterioDeSelecao {

    Integer obterPontuacao(Familia familia);
}
