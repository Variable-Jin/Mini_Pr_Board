package com.agile.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
@Getter
@Setter

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String commentWriter;

    @Column(nullable = false, length = 500)
    private String commentContents;

    // 삭제 여부 플래그
    @Column(nullable = false)
    private boolean deleted = false;


    private LocalDateTime createdAT;
    private LocalDateTime updatedAT;

    // 대댓글 가능하게 하기 위헤 ManyToOne 사용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx")
    private Board board;

}
