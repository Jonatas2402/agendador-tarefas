package com.projeto.agendadortarefas.controller;

import com.projeto.agendadortarefas.business.TarefaService;
import com.projeto.agendadortarefas.business.dto.TarefaDTO;
import com.projeto.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaDTO> salvaTarefa(@RequestBody TarefaDTO dto,
                                                 @RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(service.gravarTarefa(token, dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTarefa(@PathVariable("id") String id) {
        service.deletarTarefaPorId(id);
        return ResponseEntity.ok().build();
    }
    /*DateTimeFormat = Formata os dados de data para um formato reconhecido no banco de dados*/
    @GetMapping("/{eventos}")
    public ResponseEntity<List<TarefaDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal){
        return ResponseEntity.ok(service.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }
    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.buscaTarefasPorEmail(token));
    }
    @PatchMapping
    public ResponseEntity<TarefaDTO> alteraStatusNotificacao(@RequestParam("Status")StatusNotificacaoEnum status,
                                                             @RequestParam("id") String id){
        return ResponseEntity.ok(service.atualizaStatusDaTarefa(id, status));
    }
    @PutMapping
    public ResponseEntity<TarefaDTO> atualizaTarefa(@RequestBody TarefaDTO dto,
                                                    @RequestParam("id") String id){
        return ResponseEntity.ok(service.updateTarefas(dto, id));
    }
}
