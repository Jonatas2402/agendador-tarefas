package com.projeto.agendadortarefas.infrastructure.security;


import com.projeto.agendadortarefas.business.dto.UsuarioDTO;
import com.projeto.agendadortarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {
    // Repositório para acessar dados de usuário no banco de dados

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosDeUsuario(String email, String token){
        UsuarioDTO usuarioDTO = client.buscarUsuarioPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                .build();
    }
}
