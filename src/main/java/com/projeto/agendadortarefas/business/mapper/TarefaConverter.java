package com.projeto.agendadortarefas.business.mapper;

import com.projeto.agendadortarefas.business.dto.TarefaDTO;
import com.projeto.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    //Transforma em DTO
    TarefaEntity paraTarefaEntity(TarefaDTO dto);

    //Transforma em entidade.
    TarefaDTO paraTarefaDTO(TarefaEntity entity);
    //Transforma em DTO
    List<TarefaEntity> paraListaTarefasEntity(List<TarefaDTO> dtos);
    //Transforma em Entity
    List<TarefaDTO> paraListaTarefasDTO(List<TarefaEntity> entities);
}

