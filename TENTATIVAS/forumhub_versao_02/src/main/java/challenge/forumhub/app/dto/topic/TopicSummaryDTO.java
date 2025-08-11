package challenge.forumhub.app.dto.topic;

public record TopicSummaryDTO(
        //CRIANDO PARAMETROS DA RECORD
        long id,
        String course,
        String authorEmail,
        String title,
        String status,
        int replyCount
) {}
