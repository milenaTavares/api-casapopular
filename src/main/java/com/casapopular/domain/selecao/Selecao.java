package com.casapopular.domain.selecao;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Selecao")
public class Selecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataDeCriacao;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<FamiliaSelecionada> familiasSelecionadas;

    public Selecao(List<FamiliaSelecionada> familiasSelecionadas) {
        this.dataDeCriacao = LocalDateTime.now();
        this.familiasSelecionadas = familiasSelecionadas;
    }
}
