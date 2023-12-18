package com.casapopular.dominio.familia.pessoa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

class PessoaTest {

    @Test
    void deveCriarPessoaInformandoSeusDados() {
        String nome = "Maria";
        LocalDate dataDeNascimento = LocalDate.of(1999, 11, 22);
        Double renda = 3500.00;

        Pessoa pessoa = new Pessoa(nome, dataDeNascimento, renda);

        Assertions.assertThat(pessoa.getNome()).isEqualTo(nome);
        Assertions.assertThat(pessoa.getDataDeNascimento()).isEqualTo(dataDeNascimento);
        Assertions.assertThat(pessoa.getRenda()).isEqualTo(renda);
    }

    @Test
    void deveRetornarVerdadeiroSeAPessoaEhMaiorDeIdade() {
        Pessoa pessoa = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1990, 10, 10)).criar();

        boolean ehMaiorDeIdade = pessoa.ehMaiorDeIdade();

        Assertions.assertThat(ehMaiorDeIdade).isTrue();
    }

    @Test
    void deveRetornarFalsoSeAPessoaNaoEhMaiorDeIdade() {
        Pessoa pessoa = new PessoaBuilder().comDataDeNascimento(LocalDate.now()).criar();

        boolean ehMaiorDeIdade = pessoa.ehMaiorDeIdade();

        Assertions.assertThat(ehMaiorDeIdade).isFalse();
    }

    @Test
    void deveObterAIdadeAPartirDaDataDeNascimento() {
        Pessoa pessoa = new PessoaBuilder().comDataDeNascimento(LocalDate.of(2000, 1, 1)).criar();

        int idade = pessoa.obterIdade();

        Assertions.assertThat(idade).isEqualTo(LocalDate.now().getYear() - 2000);
    }

    @ParameterizedTest
    @MethodSource("parametrosParaLancarExcecaoDeCampoObrigatorio")
    void deveLancarExcecaoSeAlgumCampoObrigatorioForInvalido(String nome, LocalDate dataDeNascimento, Double renda, String mensagemEsperada) {
        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Pessoa(nome, dataDeNascimento, renda));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    private static Stream<Arguments> parametrosParaLancarExcecaoDeCampoObrigatorio() {
        String nome = "Maria";
        LocalDate dataDeNascimento = LocalDate.of(1999, 11, 22);
        Double renda = 1000.0;
        return Stream.of(
                Arguments.of(null, dataDeNascimento, renda, "O nome é obrigatório."),
                Arguments.of(nome, null, renda, "A data de nascimento é obrigatória."),
                Arguments.of(nome, dataDeNascimento, null, "A renda é obrigatória."));
    }
}