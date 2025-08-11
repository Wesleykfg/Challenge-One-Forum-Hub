package challenge.forumhub.app.dto.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TopicUpdateDTO(
        @NotNull(message = "O campo ID do curso é obrigatório, por favor tente novamente!")
        Long courseId,

        @NotBlank(message = "O campo nome é obrigatório, por favor tente novamente!")
        @Size(min = 3, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres")
        String title,

        @NotBlank(message = "O Campo mensagem é obrigatório, por favor tente novamente!")
        @Size(min = 10, max = 10000, message = "O campo mensagem deve ter entre {min} e {max} caracteres, por favor tente novamente!")
        String message
) {}
