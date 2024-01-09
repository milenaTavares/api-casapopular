package com.casapopular.adaptador.persistencia;

import com.casapopular.dominio.familia.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepositorio extends JpaRepository<Familia, Integer> {
}
