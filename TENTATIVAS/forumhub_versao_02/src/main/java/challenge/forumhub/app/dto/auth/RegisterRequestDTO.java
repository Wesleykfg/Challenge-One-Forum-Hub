package challenge.forumhub.app.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
        @NotEmpty(message = "O campo nome é obrigatório, por favor tente novamente!")
        @NotBlank(message = "O campo nome é obrigatório, por favor tente novamente!")
        String name,

        @NotEmpty(message = "O campo e-mail é obrigatório, por favor tente novamente!")
        @NotBlank(message = "O campo e-mail é obrigatório, por favor tente novamente!")
        @Email(message = "E-mail mal formatado")
        String email,

        @NotEmpty(message = "O campo senha é obrigatório, por favor tente novamente!")
        @NotBlank(message = "O campo senha é obrigatório, por favor tente novamente!")
        @Size(min = 8, message = "A senha deve ter 8 no mínimo 8 carateres, por favor tente novamente!")
        String password
) {}
