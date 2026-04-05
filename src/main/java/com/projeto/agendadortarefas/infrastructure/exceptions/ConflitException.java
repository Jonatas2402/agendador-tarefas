package com.projeto.agendadortarefas.infrastructure.exceptions;

public class ConflitException extends RuntimeException {
    public ConflitException(String emnsagem) {
        super(emnsagem);
    }

    public ConflitException(String mensagem, Throwable causa) {
        super(mensagem);
    }
}
