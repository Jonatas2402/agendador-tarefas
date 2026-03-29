package com.projeto.agendadortarefas.controller;

import com.projeto.agendadortarefas.business.TarefaService;
import com.projeto.agendadortarefas.business.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaDTO> salvaTarefa(@RequestBody TarefaDTO dto,
                                                 @RequestHeader("Authorization") String token){

        return ResponseEntity.ok(service.salvaTarefa(token, dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listarTarefas(@RequestParam("email") String token){
        List<TarefaDTO> tarefas = service.buscarPorEmail(token);
        return ResponseEntity.ok(tarefas);
    }
}
