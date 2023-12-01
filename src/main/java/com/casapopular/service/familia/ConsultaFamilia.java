package com.casapopular.service.familia;

import com.casapopular.domain.Familia;
import com.casapopular.domain.Pessoa;
import com.casapopular.repository.FamiliaRepository;
import com.casapopular.service.FamiliaDTO;
import com.casapopular.service.PessoaDTO;
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
        dto.idade = pessoa.getIdade();
        dto.renda = pessoa.getRenda();
        return dto;
    }
}
