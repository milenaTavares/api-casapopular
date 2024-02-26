package com.casapopular.dominio.selecao;

import com.casapopular.adaptador.persistencia.FamiliaRepositorio;
import com.casapopular.dominio.familia.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SelecaoFabrica {

    private final FamiliaRepositorio familiaRepositorio;
    private final CalculaPontuacao calculaPontuacao;

    @Autowired
    public SelecaoFabrica(FamiliaRepositorio familiaRepositorio, CalculaPontuacao calculaPontuacao) {
        this.familiaRepositorio = familiaRepositorio;
        this.calculaPontuacao = calculaPontuacao;
    }

    public Selecao fabricar(Integer numeroDeFamiliasSelecionadas) {
        List<Familia> familiasCadastradas = familiaRepositorio.findAll();
        validarFamilias(familiasCadastradas);
        List<FamiliaPontuada> familiasPontuadas = obterFamiliasPontuadas(familiasCadastradas);
        List<FamiliaPontuada> familiasSelecionadas = selecionarFamilias(familiasPontuadas, numeroDeFamiliasSelecionadas);

        return criarSelecao(familiasSelecionadas);
    }

    private void validarFamilias(List<Familia> familias) {
        if (Objects.isNull(familias) || familias.size() == 0) {
            throw new RuntimeException("Não existem famílias cadastradas.");
        }
    }

    private List<FamiliaPontuada> obterFamiliasPontuadas(List<Familia> familiasCadastradas) {
        return familiasCadastradas.stream().map(calculaPontuacao::calcular).collect(Collectors.toList());
    }

    private List<FamiliaPontuada> selecionarFamilias(List<FamiliaPontuada> familiasPontuadas, Integer numeroDeFamiliasSelecionadas) {
        return familiasPontuadas.stream()
                .sorted(Comparator.comparingInt(FamiliaPontuada::getPontuacao).reversed())
                .limit(numeroDeFamiliasSelecionadas)
                .collect(Collectors.toList());
    }

    private Selecao criarSelecao(List<FamiliaPontuada> familiasSelecionadasComPontuacao) {
        List<FamiliaSelecionada> familiaSelecionadas = familiasSelecionadasComPontuacao.stream()
                .map(FamiliaSelecionada::criar)
                .toList();
        return new Selecao(familiaSelecionadas);
    }
}
