package com.casapopular.adaptador.persistencia;

import com.casapopular.dominio.selecao.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelecaoRepositorio extends JpaRepository<Selecao, Integer> {
}
