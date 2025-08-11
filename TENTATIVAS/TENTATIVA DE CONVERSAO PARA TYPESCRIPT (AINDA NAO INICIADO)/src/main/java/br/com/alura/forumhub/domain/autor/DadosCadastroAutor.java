package br.com.alura.forumhub.domain.autor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAutor(@NotBlank //verificando e validando que o campo não está vazio
                                 String nome,
                                 @NotBlank
                                 @Email //anotação para definir o campo para receber um e-mail e verificando se o formato está correto
                                 String email,
                                 @NotNull //Nesse caso é not null pois o not blanck é apenas para strings
                                 Perfil perfil) {
}
