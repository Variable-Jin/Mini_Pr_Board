package com.agile.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class CommentDto {

    private String commentWriter;
    private String commentContents;
    private Long parentId;

    public CommentDto(String commentWriter, String commentContents, Long parentId) {
        this.commentWriter = commentWriter;
        this.commentContents = commentContents;
        this.parentId = parentId;

    }
}
