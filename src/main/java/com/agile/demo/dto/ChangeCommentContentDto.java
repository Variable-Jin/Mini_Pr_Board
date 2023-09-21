package com.agile.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCommentContentDto {

    private Long commentId;
    private String commentContents;

    public ChangeCommentContentDto(Long commentId, String commentContents) {
        this.commentId = commentId;
        this.commentContents = commentContents;
    }

}
