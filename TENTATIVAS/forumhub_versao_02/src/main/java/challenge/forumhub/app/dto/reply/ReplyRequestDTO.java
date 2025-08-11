package challenge.forumhub.app.dto.reply;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReplyRequestDTO(
        @NotNull(message = "O campo ID do tópico é obrigatório, por favor tente novamente!")
        Long topicId,

        @NotBlank(message = "Campo título é obrigatório, por favor tente novamente!")
        @Size(min = 3, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres, por favor tente novamente!")
        String title,

        @NotBlank(message = "Campo solução é obrigatório, por favor tente novamente!")
        @Size(min = 10, max = 10000, message = "O campo solução deve ter entre {min} e {max} caracteres, por favor tente novamente!")
        String solution
) {}
