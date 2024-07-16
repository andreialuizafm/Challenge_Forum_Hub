package controller;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record DadosTopico(
        @NotBlank
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        LocalDate dataCriacao,
        @NotBlank
        String status,
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        @NotBlank
        String respostas ){

}


