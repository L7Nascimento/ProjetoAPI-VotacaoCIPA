package com.estudo.cipa.votacao.controller;

import com.estudo.cipa.votacao.model.Funcionario;
import com.estudo.cipa.votacao.model.Candidato;
import com.estudo.cipa.votacao.service.FuncionarioService;
import com.estudo.cipa.votacao.service.CandidatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<Funcionario> criarOuAtualizar(@RequestBody Funcionario funcionario) {
        try {
            Funcionario salvo = funcionarioService.salvar(funcionario);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            funcionarioService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
