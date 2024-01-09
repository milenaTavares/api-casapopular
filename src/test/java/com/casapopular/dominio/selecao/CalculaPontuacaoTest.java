package com.casapopular.dominio.selecao;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.familia.pessoa.Pessoa;
import com.casapopular.dominio.familia.pessoa.PessoaBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class CalculaPontuacaoTest {

    private CalculaPontuacao calculaPontuacao;

    @BeforeEach
    void setUp() {
        calculaPontuacao = new CalculaPontuacao();
    }

    @Test
    void deveCalcularAPontuacaoTotalDeUmaFamilia() {
        Pessoa primeiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1990, 1, 1)).comRenda(500.00).criar();
        Pessoa segundoMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1980, 1, 1)).comRenda(250.00).criar();
        Pessoa terceiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.now().minusYears(2)).comRenda(0.0).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro);
        Familia familia = new Familia(membrosDaFamilia);
        int pontuacaoPorDependentesEsperada = 2;
        int pontuacaoPorRendaEsperada = 5;

        FamiliaPontuada familiaPontuada = calculaPontuacao.calcular(familia);

        Assertions.assertThat(familiaPontuada.getPontuacao()).isEqualTo(pontuacaoPorDependentesEsperada + pontuacaoPorRendaEsperada);
        Assertions.assertThat(familiaPontuada.getFamiliaId()).isEqualTo(familia.getId());
    }
}