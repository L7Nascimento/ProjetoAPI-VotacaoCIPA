package com.estudo.cipa.votacao.controller;

import com.estudo.cipa.votacao.model.Candidato;
import com.estudo.cipa.votacao.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    // Criar ou atualizar um candidato
    @PostMapping
    public ResponseEntity<Candidato> criarCandidato(@RequestBody Candidato candidato) {
        Candidato salvo = candidatoService.salvar(candidato);
        return ResponseEntity.ok(salvo);
    }

    // Listar todos os candidatos
    @GetMapping
    public ResponseEntity<List<Candidato>> listarTodos() {
        List<Candidato> candidatos = candidatoService.listarTodos();
        return ResponseEntity.ok(candidatos);
    }

    // Buscar candidato por ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidato> buscarPorId(@PathVariable Long id) {
        Candidato candidato = candidatoService.buscarPorId(id);
        return ResponseEntity.ok(candidato);
    }

    // Buscar candidato por número
    @GetMapping("/numero/{numero}")
    public ResponseEntity<Candidato> buscarPorNumero(@PathVariable Integer numero) {
        Candidato candidato = candidatoService.buscarPorNumero(numero);
        return ResponseEntity.ok(candidato);
    }

    // Deletar candidato por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        candidatoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
