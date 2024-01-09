package com.casapopular.adaptador.persistencia;

import com.casapopular.dominio.familia.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
}
