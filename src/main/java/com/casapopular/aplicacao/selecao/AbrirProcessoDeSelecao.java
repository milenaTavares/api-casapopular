package com.casapopular.aplicacao.selecao;

import com.casapopular.adaptador.persistencia.SelecaoRepositorio;
import com.casapopular.dominio.selecao.Selecao;
import com.casapopular.dominio.selecao.SelecaoFabrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AbrirProcessoDeSelecao {

    private final SelecaoFabrica selecaoFabrica;
    private final SelecaoRepositorio selecaoRepositorio;

    @Autowired
    public AbrirProcessoDeSelecao(SelecaoFabrica selecaoFabrica, SelecaoRepositorio selecaoRepositorio) {
        this.selecaoFabrica = selecaoFabrica;
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public SelecaoDTO executar(Integer numeroDeFamiliasSelecionadas) {
        Selecao selecao = selecaoFabrica.fabricar(numeroDeFamiliasSelecionadas);
        selecaoRepositorio.save(selecao);
        return montarDTO(selecao);
    }

    public SelecaoDTO montarDTO(Selecao selecao) {
        SelecaoDTO selecaoDTO = new SelecaoDTO();
        selecaoDTO.selecaoId = selecao.getId();
        selecaoDTO.dataDeCriacao = selecao.getDataDeCriacao();
        selecaoDTO.familiasSelecionadas = selecao.getFamiliasSelecionadas()
                .stream()
                .map(familiaSelecionada -> {
                    FamiliaSelecionadaDTO familiaSelecionadaDTO = new FamiliaSelecionadaDTO();
                    familiaSelecionadaDTO.familiaId = familiaSelecionada.getFamilia_id();
                    familiaSelecionadaDTO.pontuacao = familiaSelecionada.getPontuacao();
                    return familiaSelecionadaDTO;
                }).collect(Collectors.toList());
        return selecaoDTO;
    }
}
