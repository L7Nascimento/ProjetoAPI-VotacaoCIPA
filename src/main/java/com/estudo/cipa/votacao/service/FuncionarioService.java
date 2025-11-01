package com.estudo.cipa.votacao.service;

import com.estudo.cipa.votacao.model.Funcionario;
import com.estudo.cipa.votacao.model.Candidato;
import com.estudo.cipa.votacao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CandidatoService candidatoService;

    public Funcionario salvar(Funcionario funcionario) {
        if (funcionario instanceof Candidato) {
            return candidatoService.salvar((Candidato) funcionario);
        } else {
            return funcionarioRepository.save(funcionario);
        }
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> todos = new ArrayList<>(funcionarioRepository.findAll());
        todos.addAll(candidatoService.listarTodos());
        return todos;
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        Optional<Funcionario> func = funcionarioRepository.findById(id);
        if (func.isEmpty()) {
            return candidatoService.buscarPorId(id).map(f -> (Funcionario) f);
        }
        return func;
    }

    public void excluir(Long id) {
        buscarPorId(id).ifPresent(f -> {
            if (f instanceof Candidato) {
                candidatoService.excluir(f.getId());
            } else {
                funcionarioRepository.deleteById(f.getId());
            }
        });
    }
}
