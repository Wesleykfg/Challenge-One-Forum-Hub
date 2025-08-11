package challenge.forumhub.app.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequestDTO(
        @NotBlank(message = "O campo nome é obrigatório, por favor tente novamente!")
        @Size(min = 3, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres, por favor tente novamente!")
        String name
) {}
