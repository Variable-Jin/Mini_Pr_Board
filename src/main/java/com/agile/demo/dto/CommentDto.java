package com.agile.demo.dto;

import com.agile.demo.Entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {

    private Long id;
//    @JsonProperty("board_Id")
    private Long boardId;       // 댓글의 부모 id
    private String nickname;
    private String commentbody;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getBoard().getBoardId(),
                comment.getNickname(),
                comment.getCommentbody()
        );
    }

}

