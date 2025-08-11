package challenge.forumhub.app.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDTO(
        @NotEmpty(message = "O campo e-mail é obrigatório, por favor tente novamente!")
        @NotBlank(message = "O campo e-mail é obrigatório, por favor tente novamente!")
        @Email(message = "E-mail mal formatado")
        String email,

        @NotEmpty(message = "O campo senha é obrigatório, por favor tente novamente!")
        @NotBlank(message = "O campo senha é obrigatório, por favor tente novamente!")
        String password
) {}
