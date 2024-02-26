package com.casapopular.adaptador.controlador.selecao;

import com.casapopular.aplicacao.selecao.AbrirProcessoDeSelecao;
import com.casapopular.aplicacao.selecao.ConsultaProcessoDeSelecao;
import com.casapopular.aplicacao.selecao.SelecaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "selecao")
public class SelecaoRest {

    private final AbrirProcessoDeSelecao abrirProcessoDeSelecao;
    private final ConsultaProcessoDeSelecao consultaProcessoDeSelecao;

    public SelecaoRest(AbrirProcessoDeSelecao abrirProcessoDeSelecao, ConsultaProcessoDeSelecao consultaProcessoDeSelecao) {
        this.abrirProcessoDeSelecao = abrirProcessoDeSelecao;
        this.consultaProcessoDeSelecao = consultaProcessoDeSelecao;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SelecaoDTO> buscarPorId(@PathVariable Integer id) {
        SelecaoDTO dto = consultaProcessoDeSelecao.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping
    public ResponseEntity<SelecaoDTO> create(ProcessoSelecaoEntrada processoSelecaoEntrada) {
        SelecaoDTO retorno = abrirProcessoDeSelecao.executar(processoSelecaoEntrada.numeroDeFamiliasSelecionadas());
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
}
