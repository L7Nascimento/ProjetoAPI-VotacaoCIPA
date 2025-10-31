package com.estudo.cipa.votacao.controller;

import com.estudo.cipa.votacao.model.Funcionario;
import com.estudo.cipa.votacao.model.Candidato;
import com.estudo.cipa.votacao.service.FuncionarioService;
import com.estudo.cipa.votacao.service.CandidatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioControllerUnificado {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CandidatoService candidatoService;

    // Criar ou atualizar funcionário (detecta se é candidato)
    @PostMapping
    public ResponseEntity<Funcionario> criarOuAtualizar(@RequestBody Funcionario funcionario) {
        Funcionario salvo;
        if (funcionario instanceof Candidato) {
            salvo = candidatoService.salvar((Candidato) funcionario);
        } else {
            salvo = funcionarioService.salvar(funcionario);
        }
        return ResponseEntity.ok(salvo);
    }

    // Listar todos funcionários (incluindo candidatos)
    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    // Buscar por ID (funcionário ou candidato)
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Excluir por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioService.buscarPorId(id).ifPresent(func -> {
            if (func instanceof Candidato) {
                candidatoService.excluir(func.getId());
            } else {
                funcionarioService.excluir(func.getId());
            }
        });
        return ResponseEntity.noContent().build();
    }
}
