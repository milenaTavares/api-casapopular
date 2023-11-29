package com.casapopular.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer idade;

    private Double renda;

    public Pessoa(String nome, Integer idade, Double renda) {
        this.nome = nome;
        this.idade = idade;
        this.renda = renda;
    }

    public boolean ehMaiorDeIdade() {
        return this.idade >= 18;
    }
}
