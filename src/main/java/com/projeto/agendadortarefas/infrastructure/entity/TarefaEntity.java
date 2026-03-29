package com.projeto.agendadortarefas.infrastructure.entity;

import com.projeto.agendadortarefas.business.dto.UsuarioDTO;
import com.projeto.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("tarefa")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarefaEntity {
    @Id
    private String id;

    private String nomeTarefa;

    private String descricao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataEvento;

    private String emailUsuario;

    private LocalDateTime dataAlteracao;

    private StatusNotificacaoEnum statusNotificacao;
}
