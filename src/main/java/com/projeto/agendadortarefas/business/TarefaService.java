package com.projeto.agendadortarefas.business;

import com.projeto.agendadortarefas.business.dto.TarefaDTO;
import com.projeto.agendadortarefas.business.mapper.TarefaConverter;
import com.projeto.agendadortarefas.infrastructure.entity.TarefaEntity;
import com.projeto.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.projeto.agendadortarefas.infrastructure.repository.TarefaRepository;
import com.projeto.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefaDTO gravarTarefa(String token, TarefaDTO dto) {
        String email = jwtUtil.extrairEmailDoToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacao(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefaEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(
                repository.save(entity));
    }
    public List<TarefaDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                           LocalDateTime dataFinal){
        return tarefaConverter.paraListaTarefasDTO(repository
                .findByDataEventoBetween(dataInicial, dataFinal));

    }


    public void deletarTarefaPorId(String id) {
        repository.deleteById(id);
    }

    /*Próximos métodos update de tarefa*/
    public List<TarefaDTO> buscaTarefasPorEmail(String token){
        String email = jwtUtil.extrairEmailDoToken(token.substring(7));
        List<TarefaEntity> listaDeTarefas = repository.findByemailUsuario(email);

        return tarefaConverter.paraListaTarefasDTO(listaDeTarefas);
    }
}
