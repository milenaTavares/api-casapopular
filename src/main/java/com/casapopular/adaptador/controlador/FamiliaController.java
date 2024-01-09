package com.casapopular.adaptador.controlador;

import com.casapopular.aplicacao.FamiliaDTO;
import com.casapopular.aplicacao.familia.AdicionaFamilia;
import com.casapopular.aplicacao.familia.ConsultaFamilia;
import com.casapopular.aplicacao.familia.ExcluiFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "familia")
public class FamiliaController {

    private final ConsultaFamilia consultaFamilia;
    private final AdicionaFamilia adicionaFamilia;
    private final ExcluiFamilia excluiFamilia;

    @Autowired
    public FamiliaController(ConsultaFamilia consultaFamilia,
                             AdicionaFamilia adicionaFamilia,
                             ExcluiFamilia excluiFamilia) {
        this.consultaFamilia = consultaFamilia;
        this.adicionaFamilia = adicionaFamilia;
        this.excluiFamilia = excluiFamilia;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FamiliaDTO> buscarPorId(@PathVariable Integer id) {
        FamiliaDTO dto = consultaFamilia.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<FamiliaDTO>> buscarTodas() {
        List<FamiliaDTO> familias = consultaFamilia.buscarTodas();
        return ResponseEntity.status(HttpStatus.OK).body(familias);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody FamiliaEntrada familia) {
        Integer id = adicionaFamilia.adicionar(familia);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Familia adicinada com sucesso!\n Id: %d", id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        excluiFamilia.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Família excluída com sucesso!");
    }
}
