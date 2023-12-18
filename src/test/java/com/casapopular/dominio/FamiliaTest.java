package com.casapopular.dominio;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.familia.pessoa.Pessoa;
import com.casapopular.dominio.pessoa.PessoaBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FamiliaTest {

    @Test
    void deveCriarUmaFamiliaComOsMembrosInformados() {
        Pessoa primeiroMembro = new PessoaBuilder().comNome("Maria").comDataDeNascimento(LocalDate.of(1990, 1, 1)).comRenda(2000.50).criar();
        Pessoa segundoMembro = new PessoaBuilder().comNome("Joao").comDataDeNascimento(LocalDate.of(1980, 1, 1)).comRenda(4250.00).criar();
        Pessoa terceiroMembro = new PessoaBuilder().comNome("José").comDataDeNascimento(LocalDate.of(2001, 1, 1)).comRenda(1500.00).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro);

        Familia familia = new Familia(membrosDaFamilia);

        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getId)
                .containsExactlyInAnyOrder(primeiroMembro.getId(), segundoMembro.getId(), terceiroMembro.getId());
        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getNome)
                .containsExactlyInAnyOrder(primeiroMembro.getNome(), segundoMembro.getNome(), terceiroMembro.getNome());
        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getDataDeNascimento)
                .containsExactlyInAnyOrder(primeiroMembro.getDataDeNascimento(), segundoMembro.getDataDeNascimento(), terceiroMembro.getDataDeNascimento());
        Assertions.assertThat(familia.getMembros()).extracting(Pessoa::getRenda)
                .containsExactlyInAnyOrder(primeiroMembro.getRenda(), segundoMembro.getRenda(), terceiroMembro.getRenda());
    }

    @Test
    void deveObterAQuantidadeDeMembrosDaFamiliaMaioresDeIdade() {
        Pessoa primeiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1990, 1, 1)).criar();
        Pessoa segundoMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.of(1980, 1, 1)).criar();
        Pessoa terceiroMembro = new PessoaBuilder().comDataDeNascimento(LocalDate.now()).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro);
        Familia familia = new Familia(membrosDaFamilia);

        Integer quantidadeMembrosMaioresDeIdade = familia.obterQuantidadeDeMembrosMaioresDeIdade();

        Assertions.assertThat(quantidadeMembrosMaioresDeIdade).isEqualTo(2);
    }

    @Test
    void deveObterARendaTotalDaFamilia() {
        Pessoa primeiroMembro = new PessoaBuilder().comRenda(2000.50).criar();
        Pessoa segundoMembro = new PessoaBuilder().comRenda(4250.00).criar();
        Pessoa terceiroMembro = new PessoaBuilder().comRenda(0000.00).criar();
        Pessoa quartoMembro = new PessoaBuilder().comRenda(500.00).criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro, terceiroMembro, quartoMembro);
        Familia familia = new Familia(membrosDaFamilia);
        Double rendaEsperada = 6750.50;

        Double rendaTotal = familia.obterRendaTotal();

        Assertions.assertThat(rendaTotal).isEqualTo(rendaEsperada);
    }

    @Test
    void deveAdicionarMembrosNaFamilia() {
        Pessoa primeiroMembro = new PessoaBuilder().criar();
        Pessoa segundoMembro = new PessoaBuilder().criar();
        Pessoa novoMembro = new PessoaBuilder().criar();
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro);
        Familia familia = new Familia(membrosDaFamilia);

        familia.adicionarMembros(Collections.singletonList(novoMembro));

        Assertions.assertThat(familia.getMembros()).containsExactlyInAnyOrder(primeiroMembro, segundoMembro, novoMembro);
    }

    @Test
    void deveExcluirMembroDaFamilia() {
        Integer idParaExcluir = 1;
        Pessoa primeiroMembro = new PessoaBuilder().criar();
        primeiroMembro.setId(idParaExcluir);
        Pessoa segundoMembro = new PessoaBuilder().criar();
        segundoMembro.setId(2);
        List<Pessoa> membrosDaFamilia = Arrays.asList(primeiroMembro, segundoMembro);
        Familia familia = new Familia(membrosDaFamilia);

        familia.excluirMembro(idParaExcluir);

        Assertions.assertThat(familia.getMembros()).containsOnly(segundoMembro);
    }
}