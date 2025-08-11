package challenge.forumhub.app.dto.category;

public record CategorySummaryDTO(
        //CRIANDO PARAMETROS DA RECORD
        long id,
        String name,
        int courseCount
) {}
