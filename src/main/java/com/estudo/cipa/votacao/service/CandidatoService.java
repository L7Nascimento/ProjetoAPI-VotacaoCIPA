package com.estudo.cipa.votacao.service;
//imports
import com.estudo.cipa.votacao.model.Candidato;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoService {
    private final List<Candidato> candidatos = new ArrayList<>();

    public CandidatoService(){
        candidatos.add(new Candidato(1,"Maria Helena", "RH","foto/MariaH.jpg"));
        candidatos.add(new Candidato(2,"Pedro Valença", "Bloco 5","foto/PedroV.jpg"));
        candidatos.add(new Candidato(3,"Agnaldo Raiol", "Seguranca","foto/AgnaldoR.jpg"));

    }

    //Metodo que lista todos os candidatos -  tipo list

    public List<Candidato> listarTodos() {
        return candidatos;
    }

    //Metodo que encontra atraves de Stream o primeiro candidato com o parametro numero passado e retorna um tratamento de erro
    public Candidato buscarPorNumero(int numero){
        return candidatos.stream().filter(c -> c.getNumero() == numero).findFirst().orElse(null);
    }

}
