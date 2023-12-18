package com.casapopular.dominio.pessoa;

import com.casapopular.dominio.familia.pessoa.Pessoa;

import java.time.LocalDate;

public class PessoaBuilder {
    private String nome;
    private LocalDate dataDeNascimento;
    private Double renda;

    public PessoaBuilder() {
        this.nome = "Maria José";
        this.dataDeNascimento = LocalDate.of(2000, 10, 20);
        this.renda = 5000.0;
    }

    public Pessoa criar() {
        return new Pessoa(nome, dataDeNascimento, renda);
    }

    public PessoaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder comDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public PessoaBuilder comRenda(Double renda) {
        this.renda = renda;
        return this;
    }
}
