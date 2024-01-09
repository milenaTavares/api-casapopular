package com.casapopular.dominio.selecao;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.selecao.criterio.CriterioDeSelecao;
import com.casapopular.dominio.selecao.criterio.NumeroDeDependentes;
import com.casapopular.dominio.selecao.criterio.RendaTotal;

import java.util.Arrays;
import java.util.List;

public class CalculaPontuacao {

    private final List<CriterioDeSelecao> criteriosDeSelecao;

    public CalculaPontuacao() {
        CriterioDeSelecao numeroDeDependentes = new NumeroDeDependentes();
        CriterioDeSelecao rendaTotal = new RendaTotal();
        this.criteriosDeSelecao = Arrays.asList(numeroDeDependentes, rendaTotal);
    }

    public FamiliaPontuada calcular(Familia familia) {
        Integer pontuacaoDaFamilia = criteriosDeSelecao.stream().mapToInt(criterio -> criterio.obterPontuacao(familia)).sum();
        return new FamiliaPontuada(familia.getId(), pontuacaoDaFamilia);
    }
}
