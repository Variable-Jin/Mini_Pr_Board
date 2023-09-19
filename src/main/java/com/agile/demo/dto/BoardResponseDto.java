package com.agile.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponseDto {

    private Long BoardIdx;
    private String title;
    private String contents;

    public BoardResponseDto() {}

    public BoardResponseDto(Long BoardIdx, String title, String contents) {
        this.BoardIdx = BoardIdx;
        this.title = title;
        this.contents = contents;
    }

}
