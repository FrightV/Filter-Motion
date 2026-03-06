package com.filtermotion.controller;

import com.filtermotion.model.AlertaPreco;
import com.filtermotion.service.AlertaPrecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaPrecoController {

    private final AlertaPrecoService alertaPrecoService;

    @PostMapping
    public AlertaPreco criar(@RequestBody AlertaPreco alerta) {
        return alertaPrecoService.salvar(alerta);
    }

    @GetMapping
    public List<AlertaPreco> listar() {
        return alertaPrecoService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alertaPrecoService.deletar(id);
    }

}