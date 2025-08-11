package challenge.forumhub.app.dto.course;

public record CourseSummaryDTO(
        //CRIANDO PARAMETROS DA RECORD
        long id,
        String name,
        int categoryCount
) {}
