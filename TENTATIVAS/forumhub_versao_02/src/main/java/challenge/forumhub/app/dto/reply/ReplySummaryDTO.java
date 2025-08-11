package challenge.forumhub.app.dto.reply;

public record ReplySummaryDTO(
        //CRIANDO PARAMETROS DA RECORD
        String authorEmail,
        long topicId,
        String topicTitle,
        long replyId,
        String replyTitle
) {}
