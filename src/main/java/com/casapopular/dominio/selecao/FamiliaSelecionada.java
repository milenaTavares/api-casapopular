package com.casapopular.dominio.selecao;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class FamiliaSelecionada {

    private Integer familia_id;

    private Integer pontuacao;

    public FamiliaSelecionada(Integer familia_id, Integer pontuacao) {
        this.familia_id = familia_id;
        this.pontuacao = pontuacao;
    }

    public static FamiliaSelecionada criar(FamiliaPontuada familiaPontuada) {
        return new FamiliaSelecionada(familiaPontuada.getFamiliaId(), familiaPontuada.getPontuacao());
    }
}
