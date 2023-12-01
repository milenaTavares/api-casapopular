package com.casapopular.controller.familia;

import com.casapopular.domain.Familia;
import com.casapopular.service.FamiliaDTO;
import com.casapopular.service.familia.AdicionaFamilia;
import com.casapopular.service.familia.ConsultaFamilia;
import com.casapopular.service.familia.ExcluiFamilia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    @RequestMapping(value = "buscartodas")
    public ResponseEntity<List<FamiliaDTO>> buscarTodas() {
        List<FamiliaDTO> familias = consultaFamilia.buscarTodas();
        return ResponseEntity.ok().body(familias);
    }


    @PostMapping
    public ResponseEntity<Familia> create(@RequestBody Familia familia) {
        Integer id = adicionaFamilia.adicionar(familia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        excluiFamilia.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
