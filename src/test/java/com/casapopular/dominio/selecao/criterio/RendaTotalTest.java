package com.casapopular.dominio.selecao.criterio;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.familia.pessoa.Pessoa;
import com.casapopular.dominio.familia.pessoa.PessoaBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class RendaTotalTest {

    private CriterioDeSelecao criterioDeSelecao;

    @BeforeEach
    void setUp() {
        criterioDeSelecao = new RendaTotal();
    }

    @Test
    void deveObterPontuacaoQuandoPossuirRendaMenorIgualANovecentosReais() {
        Pessoa primeiroMembro = new PessoaBuilder().comRenda(500.0).criar();
        Familia familia = new Familia(Collections.singletonList(primeiroMembro));

        Integer pontuacao = criterioDeSelecao.obterPontuacao(familia);

        Assertions.assertThat(pontuacao).isEqualTo(5);
    }

    @Test
    void deveObterPontuacaoQuandoPossuirRendaMaiorQueNovecentosEMenorQueMilEQuinhentosReais() {
        Pessoa primeiroMembro = new PessoaBuilder().comRenda(1000.0).criar();
        Pessoa segundoMembro = new PessoaBuilder().comRenda(200.0).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro);
        Familia familia = new Familia(membrosDaFamilia);

        Integer pontuacao = criterioDeSelecao.obterPontuacao(familia);

        Assertions.assertThat(pontuacao).isEqualTo(3);
    }

    @Test
    void deveObterPontuacaoQuandoPossuirRendaMaiorQueMilEQuinhentosReais() {
        Pessoa primeiroMembro = new PessoaBuilder().comRenda(1000.0).criar();
        Pessoa segundoMembro = new PessoaBuilder().comRenda(2000.0).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro);
        Familia familia = new Familia(membrosDaFamilia);

        Integer pontuacao = criterioDeSelecao.obterPontuacao(familia);

        Assertions.assertThat(pontuacao).isEqualTo(0);
    }
}