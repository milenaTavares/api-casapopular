package com.casapopular.dominio.selecao.criterio;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.familia.pessoa.Pessoa;
import com.casapopular.dominio.familia.pessoa.PessoaBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class NumeroDeDependentesTest {

    private CriterioDeSelecao criterioDeSelecao;

    @BeforeEach
    void setUp() {
        criterioDeSelecao = new NumeroDeDependentes();
    }

    @Test
    void deveObterPontuacaoQuandoPossuirMenosQueTresMembrosMaioresDeIdade() {
        Pessoa primeiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1990, 1, 1)).criar();
        Pessoa segundoMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1980, 1, 1)).criar();
        Pessoa terceiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.now()).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro);
        Familia familia = new Familia(membrosDaFamilia);

        Integer pontuacao = criterioDeSelecao.obterPontuacao(familia);

        Assertions.assertThat(pontuacao).isEqualTo(2);
    }

    @Test
    void deveObterPontuacaoQuandoPossuirTresOuMaisMembrosMaioresDeIdade() {
        Pessoa primeiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1990, 1, 1)).criar();
        Pessoa segundoMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1980, 1, 1)).criar();
        Pessoa terceiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1970, 1, 1)).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro);
        Familia familia = new Familia(membrosDaFamilia);

        Integer pontuacao = criterioDeSelecao.obterPontuacao(familia);

        Assertions.assertThat(pontuacao).isEqualTo(3);
    }
}