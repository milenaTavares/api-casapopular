package com.casapopular.aplicacao.familia;

import com.casapopular.dominio.familia.Familia;
import com.casapopular.dominio.familia.pessoa.Pessoa;
import com.casapopular.adaptador.repositorio.FamiliaRepository;
import com.casapopular.aplicacao.FamiliaDTO;
import com.casapopular.aplicacao.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaFamilia {

    private final FamiliaRepository familiaRepository;

    @Autowired
    public ConsultaFamilia(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    public List<FamiliaDTO> buscarTodas() {
        List<Familia> familias = familiaRepository.findAll();
        return familias.stream().map(this::montarFamiliaDTO).collect(Collectors.toList());
    }

    public FamiliaDTO buscarPorId(Integer id) {
        Familia familia = familiaRepository.findById(id).get();
        return montarFamiliaDTO(familia);
    }

    private FamiliaDTO montarFamiliaDTO(Familia familia) {
        FamiliaDTO dto = new FamiliaDTO();
        dto.id = familia.getId();
        dto.membros = familia.getMembros().stream().map(this::montarPessoaDTO).collect(Collectors.toList());
        return dto;
    }

    private PessoaDTO montarPessoaDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.id = pessoa.getId();
        dto.nome = pessoa.getNome();
        dto.idade = pessoa.obterIdade();
        dto.renda = pessoa.getRenda();
        return dto;
    }
}
