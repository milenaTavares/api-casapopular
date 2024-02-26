package com.casapopular.aplicacao.selecao;

import com.casapopular.adaptador.persistencia.SelecaoRepositorio;
import com.casapopular.dominio.selecao.Selecao;
import com.casapopular.dominio.selecao.SelecaoFabrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrirProcessoDeSelecao {

    private final SelecaoFabrica selecaoFabrica;
    private final SelecaoRepositorio selecaoRepositorio;

    @Autowired
    public AbrirProcessoDeSelecao(SelecaoFabrica selecaoFabrica, SelecaoRepositorio selecaoRepositorio) {
        this.selecaoFabrica = selecaoFabrica;
        this.selecaoRepositorio = selecaoRepositorio;
    }

    public SelecaoSaida executar(Integer numeroDeFamiliasSelecionadas) {
        Selecao selecao = selecaoFabrica.fabricar(numeroDeFamiliasSelecionadas);
        selecaoRepositorio.save(selecao);
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
