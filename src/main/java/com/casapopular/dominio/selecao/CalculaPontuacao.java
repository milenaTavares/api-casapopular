package com.casapopular.dominio.selecao;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.selecao.criterio.CriterioDeSelecao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculaPontuacao {

    private final List<CriterioDeSelecao> criteriosDeSelecao;

    public CalculaPontuacao(List<CriterioDeSelecao> criteriosDeSelecao) {
        this.criteriosDeSelecao = criteriosDeSelecao;
    }

    public FamiliaPontuada calcular(Familia familia) {
        Integer pontuacaoDaFamilia = criteriosDeSelecao.stream().mapToInt(criterio -> criterio.obterPontuacao(familia)).sum();
        return new FamiliaPontuada(familia.getId(), pontuacaoDaFamilia);
    }
}
