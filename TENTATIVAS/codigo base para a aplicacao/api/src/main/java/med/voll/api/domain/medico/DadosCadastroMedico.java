package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank //verificando e validando que o campo não está vazio
        String nome,
        @NotBlank
        @Email //anotação para definir o campo para receber um e-mail e verificando se o formato está correto
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //anotação para colocar um limite de digitos sendo ele no exemplo 4 a 6
        String crm,
        @NotNull //Nesse caso é not null pois o not blanck é apenas para strings
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
