package com.projeto.agendadortarefas.infrastructure.repository;

import com.projeto.agendadortarefas.business.dto.TarefaDTO;
import com.projeto.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends MongoRepository<TarefaEntity, String> {

    List<TarefaEntity> findByEmailUsuario(String email);
}
