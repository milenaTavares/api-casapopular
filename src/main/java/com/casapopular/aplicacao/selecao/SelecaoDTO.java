package com.casapopular.aplicacao.selecao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SelecaoDTO {

    public Integer selecaoId;
    public LocalDateTime dataDeCriacao;
    public List<FamiliaSelecionadaDTO> familiasSelecionadas = new ArrayList<>();
}
