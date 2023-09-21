package com.agile.demo.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Comment")
@Getter
@Setter

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false, length = 30)
    private String commentWriter;

    @Column(nullable = false, length = 500)
    private String commentContents;

    private LocalDateTime createdAT;
    private LocalDateTime updatedAT;

    // 대댓글 가능하게 하기 위헤 ManyToOne 사용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_idx")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Comment parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comment> childComments = new ArrayList<>();


}
