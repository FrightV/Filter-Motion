/*package com.filtermotion.service;

import com.filtermotion.model.AlertaPreco;
import com.filtermotion.repository.AlertaPrecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaPrecoService {

    private final AlertaPrecoRepository alertaPrecoRepository;

    public AlertaPreco salvar(AlertaPreco alerta) {
        return alertaPrecoRepository.save(alerta);
    }

    public List<AlertaPreco> listarTodos() {
        return alertaPrecoRepository.findAll();
    }

    public void deletar(Long id) {
        alertaPrecoRepository.deleteById(id);
    }

}*/