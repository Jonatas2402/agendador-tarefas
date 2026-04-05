package com.projeto.agendadortarefas.business.mapper;

import com.projeto.agendadortarefas.business.dto.TarefaDTO;
import com.projeto.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    //Transforma en entidade
    TarefaEntity paraTarefaEntity(TarefaDTO dto);

    //Transforma em DTO.
    TarefaDTO paraTarefaDTO(TarefaEntity entity);
    //Transforma em entidade
    List<TarefaEntity> paraListaTarefasEntity(List<TarefaDTO> dtos);
    //Transforma em DTO
    List<TarefaDTO> paraListaTarefasDTO(List<TarefaEntity> entities);
}

