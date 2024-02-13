package com.agile.demo.dto;

import com.agile.demo.Entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Long BoardId;
    private String title;
    private String contents;

    public Board toEntity() {
        return new Board(BoardId, title, contents);
    }



//    // LocalDateTime
//    private String createdAt;
//    private String updatedAT;



}
