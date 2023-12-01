package com.casapopular.domain;

import com.casapopular.domain.familia.pessoa.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PessoaTest {

    @Test
    void deveCriarPessoaInformandoSeusDados() {
        String nome = "Maria";
        Integer idade = 20;
        Double renda = 3500.00;

        Pessoa pessoa = new Pessoa(nome, idade, renda);

        Assertions.assertThat(pessoa.getNome()).isEqualTo(nome);
        Assertions.assertThat(pessoa.getIdade()).isEqualTo(idade);
        Assertions.assertThat(pessoa.getRenda()).isEqualTo(renda);
    }

    @Test
    void deveRetornarVerdadeiroSeAPessoaEhMaiorDeIdade() {
        Pessoa pessoa = new Pessoa("Maria", 18, 2000.00);

        boolean ehMaiorDeIdade = pessoa.ehMaiorDeIdade();

        Assertions.assertThat(ehMaiorDeIdade).isTrue();
    }

    @Test
    void deveRetornarFalsoSeAPessoaNaoEhMaiorDeIdade() {
        Pessoa pessoa = new Pessoa("Maria", 10, 2000.00);

        boolean ehMaiorDeIdade = pessoa.ehMaiorDeIdade();

        Assertions.assertThat(ehMaiorDeIdade).isFalse();
    }

    @ParameterizedTest
    @MethodSource("parametrosParaLancarExcecaoDeCampoObrigatorio")
    void deveLancarExcecaoSeAlgumCampoObrigatorioForInvalido(String nome, Integer idade, Double renda, String mensagemEsperada) {
        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Pessoa(nome, idade, renda));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    private static Stream<Arguments> parametrosParaLancarExcecaoDeCampoObrigatorio() {
        String nome = "Maria";
        Integer idade = 20;
        Double renda = 1000.0;
        return Stream.of(
                Arguments.of(null, idade, renda, "O nome é obrigatório."),
                Arguments.of(nome, null, renda, "A idade é obrigatória."),
                Arguments.of(nome, idade, null, "A renda é obrigatória."));
    }
}