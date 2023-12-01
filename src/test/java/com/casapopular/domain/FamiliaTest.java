package com.casapopular.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FamiliaTest {

    @Test
    void deveCriarUmaFamiliaComOsMembrosInformados() {
        Pessoa primeiroMembro = new Pessoa("Maria", 45, 2000.50);
        Pessoa segundoMembro = new Pessoa("Joao", 47, 4250.00);
        Pessoa terceiroMembro = new Pessoa("José", 19, 1500.00);
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro);

        Familia familia = new Familia(membrosDaFamilia);

        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getId)
                .containsExactlyInAnyOrder(primeiroMembro.getId(), segundoMembro.getId(), terceiroMembro.getId());
        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getNome)
                .containsExactlyInAnyOrder(primeiroMembro.getNome(), segundoMembro.getNome(), terceiroMembro.getNome());
        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getIdade)
                .containsExactlyInAnyOrder(primeiroMembro.getIdade(), segundoMembro.getIdade(), terceiroMembro.getIdade());
        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getRenda)
                .containsExactlyInAnyOrder(primeiroMembro.getRenda(), segundoMembro.getRenda(), terceiroMembro.getRenda());
    }

    @Test
    void deveObterAQuantidadeDeMembrosDaFamiliaMaioresDeIdade() {
        Pessoa primeiroMembro = new Pessoa("Maria", 45, 2000.50);
        Pessoa segundoMembro = new Pessoa("José", 18, 0000.00);
        Pessoa terceiroMembro = new Pessoa("Joana", 15, 500.00);
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro);
        Familia familia = new Familia(membrosDaFamilia);

        Integer quantidadeMembrosMaioresDeIdade = familia.obterQuantidadeDeMembrosMaioresDeIdade();

        Assertions.assertThat(quantidadeMembrosMaioresDeIdade).isEqualTo(2);
    }

    @Test
    void deveObterARendaTotalDaFamilia() {
        Pessoa primeiroMembro = new Pessoa("Maria", 45, 2000.50);
        Pessoa segundoMembro = new Pessoa("Joao", 47, 4250.00);
        Pessoa terceiroMembro = new Pessoa("José", 19, 0000.00);
        Pessoa quartoMembro = new Pessoa("Joana", 15, 500.00);
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro, quartoMembro);
        Familia familia = new Familia(membrosDaFamilia);
        Double rendaEsperada = 6750.50;

        Double rendaTotal = familia.obterRendaTotal();

        Assertions.assertThat(rendaTotal).isEqualTo(rendaEsperada);
    }

    @Test
    void deveAdicionarMembrosNaFamilia() {
        Pessoa primeiroMembro = new Pessoa("Maria", 45, 2000.50);
        Pessoa segundoMembro = new Pessoa("Joao", 47, 4250.00);
        Pessoa novoMembro = new Pessoa("José", 19, 1500.00);
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro);
        Familia familia = new Familia(membrosDaFamilia);

        familia.adicionarMembros(Collections.singletonList(novoMembro));

        Assertions.assertThat(familia.getMembros()).containsExactlyInAnyOrder(primeiroMembro, segundoMembro, novoMembro);
    }

    @Test
    void deveExcluirMembroDaFamilia() {
        Integer idParaExcluir = 1;
        Pessoa primeiroMembro = new Pessoa("Maria", 45, 2000.50);
        primeiroMembro.setId(idParaExcluir);
        Pessoa segundoMembro = new Pessoa("Joao", 47, 4250.00);
        segundoMembro.setId(2);
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro);
        Familia familia = new Familia(membrosDaFamilia);

        familia.excluirMembro(idParaExcluir);

        Assertions.assertThat(familia.getMembros()).containsOnly(primeiroMembro);
    }
}