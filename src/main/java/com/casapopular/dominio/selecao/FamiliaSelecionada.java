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
}
