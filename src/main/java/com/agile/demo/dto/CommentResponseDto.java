package com.agile.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommentResponseDto {

    private Long commentId;
    private String commentWriter;
    private String commentContents;
    private Long parentId;
    private List<CommentResponseDto> children = new ArrayList<>();

    public CommentResponseDto() {}

    public CommentResponseDto(Long commentId, String commentWriter, String commentContents, Long parentId) {

        this.commentId = commentId;
        this.commentWriter = commentWriter;
        this.commentContents = commentContents;
        this.parentId = parentId;
    }

}
