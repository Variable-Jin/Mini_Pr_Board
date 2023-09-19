package com.agile.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class BoardDto {

    private String title;
    private String contents;

    public BoardDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
