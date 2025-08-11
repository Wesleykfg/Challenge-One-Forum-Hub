package challenge.forumhub.app.dto.user;

public record UserSummaryDTO(
        //CRIANDO PARAMETROS DA RECORD
        long id,
        String email,
        int topicCount,
        int replyCount
) {}
