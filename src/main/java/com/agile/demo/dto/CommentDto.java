package com.agile.demo.dto;

import com.agile.demo.Entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentDto {

    private Long id;
    @JsonProperty("board_id")
    private Long boardId;       // 댓글의 부모 id
    private String nickname;
    private String commentbody;
    private Long parentId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAT;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAT;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getBoard().getBoardId(),
                comment.getNickname(),
                comment.getCommentbody(),
                comment.getParentId(),
                comment.getCreatedAT(),
                comment.getUpdatedAT()
        );
    }

    public static CommentDto createReplyCommentDto(Comment createdReply) {
        return new CommentDto(
                createdReply.getId(),
                createdReply.getBoard().getBoardId(),
                createdReply.getNickname(),
                createdReply.getCommentbody(),
                createdReply.getParentId(),
                createdReply.getCreatedAT(),
                createdReply.getUpdatedAT()
        );
    }
}

