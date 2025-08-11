package challenge.forumhub.app.dto.reply;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ReplyDetailsDTO(
        //CRIANDO PARAMETROS DA RECORD
        long id,
        String topic,
        String authorName,
        String authorEmail,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime createdAt,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime modifiedAt,
        String title,
        String solution
) {}
