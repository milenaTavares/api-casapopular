package com.casapopular.adaptador.persistencia;

import com.casapopular.dominio.selecao.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelecaoRepositorio extends JpaRepository<Selecao, Integer> {
}
