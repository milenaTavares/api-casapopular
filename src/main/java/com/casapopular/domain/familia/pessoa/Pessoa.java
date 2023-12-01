package com.casapopular.domain.familia.pessoa;

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

    @NotNull(message = "A idade é obrigatória.")
    @Min(0)
    private Integer idade;

    @NotNull(message = "A renda é obrigatória.")
    @Min(0)
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
