package com.estudo.cipa.votacao.service;

import com.estudo.cipa.votacao.model.Candidato;
import com.estudo.cipa.votacao.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato salvar(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> buscarPorId(Long id) {
        return candidatoRepository.findById(id);
    }

    // Buscar candidato pelo número
    public Optional<Candidato> buscarPorNumero(Integer numero) {
        return candidatoRepository.findByNumero(numero);
    }

    public void excluir(Long id) {
        candidatoRepository.deleteById(id);
    }
}
