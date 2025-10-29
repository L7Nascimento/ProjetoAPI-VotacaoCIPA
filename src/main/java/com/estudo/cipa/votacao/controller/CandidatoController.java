package com.estudo.cipa.votacao.controller;
//imports
import com.estudo.cipa.votacao.model.Candidato;
import com.estudo.cipa.votacao.service.CandidatoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController // Anotação controller
public class CandidatoController {
    private final CandidatoService candidatoService;

    // contrutor com injeção de dependencia da classe CandidatoService
    public CandidatoController(CandidatoService candidatoService){
        this.candidatoService = candidatoService;

    }
    // Listar todos os candidatos
    @GetMapping("/candidatos")
    public List<Candidato> listar(){
        return candidatoService.listarTodos();
    }
    //Buscar candidato pelo numero
    @GetMapping("/candidato/{numero}")
    public Candidato buscar(@PathVariable int numero){
        return candidatoService.buscarPorNumero(numero);

    }


}
