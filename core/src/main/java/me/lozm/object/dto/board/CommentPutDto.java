package me.lozm.object.dto.board;

import lombok.Getter;
import me.lozm.object.code.CommentType;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotNull;

public class CommentPutDto {

    @Getter
    public static class Request extends BaseUserDto {
        @NotNull
        private Long id;

        private CommentType commentType;

        private String content;
    }

}
