package com.casapopular.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Familia")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "familia_id")
    private List<Pessoa> membros;

    public Familia(List<Pessoa> membros) {
        this.membros = membros;
    }

    public Integer obterQuantidadeDeMembrosMaioresDeIdade() {
        return this.membros.stream().filter(Pessoa::ehMaiorDeIdade).toList().size();
    }

    public Double obterRendaTotal() {
        return this.membros.stream().mapToDouble(Pessoa::getRenda).sum();
    }

    public void adicionarMembros(List<Pessoa> novosMembros) {
        List<Pessoa> todosOsMembros = new ArrayList<>();
        todosOsMembros.addAll(this.membros);
        todosOsMembros.addAll(novosMembros);
        this.membros = todosOsMembros;
    }

    public void excluirMembro(Integer membroId) {
        this.membros = membros.stream().filter(membro -> !membro.getId().equals(membroId)).collect(Collectors.toList());
    }
}
