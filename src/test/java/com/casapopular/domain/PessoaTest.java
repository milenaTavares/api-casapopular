package com.casapopular.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}