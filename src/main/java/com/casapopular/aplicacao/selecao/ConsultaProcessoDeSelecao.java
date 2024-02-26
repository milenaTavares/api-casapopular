package com.casapopular.aplicacao.selecao;

import com.casapopular.adaptador.persistencia.SelecaoRepositorio;
import com.casapopular.dominio.selecao.Selecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaProcessoDeSelecao {

    private final SelecaoRepositorio selecaoRepositorio;

    @Autowired
    public ConsultaProcessoDeSelecao(SelecaoRepositorio selecaoRepositorio) {
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public SelecaoSaida buscarPorId(Integer id) {
        Selecao selecao = selecaoRepositorio.findById(id).get();
        return montarSaida(selecao);
    }

    private SelecaoSaida montarSaida(Selecao selecao) {
        List<FamiliaSelecionadaSaida> familiasSelecionadasSaida = selecao.getFamiliasSelecionadas()
                .stream()
                .map(familiaSelecionada -> new FamiliaSelecionadaSaida(familiaSelecionada.getFamilia_id(), familiaSelecionada.getPontuacao()))
                .toList();
        return new SelecaoSaida(selecao.getId(), selecao.getDataDeCriacao(), familiasSelecionadasSaida);
    }
}
