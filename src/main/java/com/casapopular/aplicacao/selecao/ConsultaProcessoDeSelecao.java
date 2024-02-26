package com.casapopular.aplicacao.selecao;

import com.casapopular.adaptador.persistencia.SelecaoRepositorio;
import com.casapopular.dominio.selecao.Selecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ConsultaProcessoDeSelecao {

    private final SelecaoRepositorio selecaoRepositorio;

    @Autowired
    public ConsultaProcessoDeSelecao(SelecaoRepositorio selecaoRepositorio) {
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public SelecaoDTO buscarPorId(Integer id) {
        Selecao selecao = selecaoRepositorio.findById(id).get();
        return montarDTO(selecao);
    }

    private SelecaoDTO montarDTO(Selecao selecao) {
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
