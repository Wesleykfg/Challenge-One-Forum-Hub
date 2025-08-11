package challenge.forumhub.app.dto.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TopicRequestDTO(
        @NotNull(message = "O campo ID do tópico é obrigatório, por favor tente novamente!")
        Long courseId,

        @NotBlank(message = "O campo título é obrigatório, por favor tente novamente!")
        @Size(min = 3, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres, por favor tente novamente!")
        String title,

        @NotBlank(message = "o campo mensagem é obrigatório, por favor tente novamente!")
        @Size(min = 10, max = 10000, message = "O campo mensagem deve ter entre {min} e {max} caracteres, por favor tente novamente!")
        String message
) {}
