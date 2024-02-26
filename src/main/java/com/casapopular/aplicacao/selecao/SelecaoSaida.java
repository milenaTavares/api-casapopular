package com.casapopular.aplicacao.selecao;

import java.time.LocalDateTime;
import java.util.List;

public record SelecaoSaida(Integer selecaoId,
                           LocalDateTime dataDeCriacao,
                           List<FamiliaSelecionadaSaida> familiasSelecionadas) {
}
