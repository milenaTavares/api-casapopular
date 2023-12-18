package com.casapopular.dominio.familia.pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "Pessoa")
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotNull(message = "A A data de nascimento é obrigatória.")
    private LocalDate dataDeNascimento;

    @NotNull(message = "A renda é obrigatória.")
    @Min(0)
    private Double renda;

    public Pessoa(String nome, LocalDate dataDeNascimento, Double renda) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.renda = renda;
    }

    public int obterIdade() {
        LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(this.dataDeNascimento, dataAtual);
        return periodo.getYears();
    }

    public boolean ehMaiorDeIdade() {
        return this.obterIdade() >= 18;
    }
}
