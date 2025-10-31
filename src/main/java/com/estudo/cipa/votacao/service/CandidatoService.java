package com.estudo.cipa.votacao.service;

import com.estudo.cipa.votacao.model.Candidato;
import com.estudo.cipa.votacao.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    // Salvar ou atualizar candidato
    public Candidato salvar(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    // Buscar por ID
    public Candidato buscarPorId(Long id) {
        return candidatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado com id: " + id));
    }

    // Buscar por número do candidato
    public Candidato buscarPorNumero(Integer numero) {
        return candidatoRepository.findByNumero(numero)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado com número: " + numero));
    }

    // Listar todos os candidatos
    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }

    // Deletar por ID
    public void excluir(Long id) {
        candidatoRepository.deleteById(id);
    }
}
