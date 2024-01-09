package com.casapopular.adaptador.controlador;

import com.casapopular.aplicacao.selecao.AbrirProcessoDeSelecao;
import com.casapopular.aplicacao.selecao.SelecaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "selecao")
public class SelecaoControlador {

    private final AbrirProcessoDeSelecao abrirProcessoDeSelecao;

    @Autowired
    public SelecaoControlador(AbrirProcessoDeSelecao abrirProcessoDeSelecao) {
        this.abrirProcessoDeSelecao = abrirProcessoDeSelecao;
    }

    @PostMapping
    public ResponseEntity<SelecaoDTO> create(@RequestParam("numeroDeFamiliasSelecionadas") Integer numeroDeFamiliasSelecionadas) {
        SelecaoDTO retorno = abrirProcessoDeSelecao.executar(numeroDeFamiliasSelecionadas);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
}