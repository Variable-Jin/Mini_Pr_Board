package com.agile.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {

    private Long commentId;
    private String commentWriter;
    private String commentContents;

    public CommentResponseDto() {}

    public CommentResponseDto(Long commentId, String commentWriter, String commentContents) {
        this.commentId = commentId;
        this.commentWriter = commentWriter;
        this.commentContents = commentContents;
    }

}
