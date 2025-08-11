package challenge.forumhub.app.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record CourseUpdateDTO(
        @NotBlank(message = "O campo nome é obrigatório, por favor tente novamente!")
        @Size(min = 3, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres, por favor tente novamente!")
        String name,

        @NotEmpty(message = "Pelo menos o ID de uma categoria deve ser informado, por favor tente novamente")
        Set<Long> categoryIds
) {}
