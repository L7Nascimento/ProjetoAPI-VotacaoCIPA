package com.estudo.cipa.votacao.service;

import com.estudo.cipa.votacao.model.Funcionario;
import com.estudo.cipa.votacao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Salvar ou atualizar um funcionário
    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Buscar por ID
    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    // Listar todos
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    // Excluir por ID
    public void excluir(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
