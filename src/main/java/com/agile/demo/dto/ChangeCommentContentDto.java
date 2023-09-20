package com.agile.demo.dto;

public class ChangeCommentContentDto {

    private Long commentId;
    private String commentContents;

    public ChangeCommentContentDto(Long commentId, String commentContents) {
        this.commentId = commentId;
        this.commentContents = commentContents;
    }
}
