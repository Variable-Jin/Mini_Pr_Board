package com.agile.demo.Entity;


import com.agile.demo.dto.CommentDto;
import com.agile.demo.repository.CommentRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Board_id")
    private Board board;

    @Column
    private String nickname;

    @Column
    private String commentbody;

    @Column(name = "parent_id")
    private Long parentId; // 부모 댓글의 ID

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAT;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAT;

    // 생성 자동으로 설정
    @PrePersist
    public void setCreate() {
        this.createdAT = LocalDateTime.now();
        this.updatedAT = LocalDateTime.now();
    }


    public static Comment createComment(CommentDto commentDto, Board board) {
        if (commentDto.getId() != null)
            throw new IllegalArgumentException("댓글 생성을 실패했습니다. 댓글의 id가 없어야 합니다.");
        if (commentDto.getBoardId() != board.getBoardId())
            throw new IllegalArgumentException("댓글 생성을 실패했습니다. 게시글의 id가 없어야 합니다.");


        return new Comment(
                commentDto.getId(),
                board,
                commentDto.getNickname(),
                commentDto.getCommentbody(),
                null,
                commentDto.getCreatedAT(),
                commentDto.getUpdatedAT()
        );



    }

    public static Comment createReply (CommentDto commentDto, Board board, Comment parentComment) {
        if (commentDto.getId() !=null)
            throw new IllegalArgumentException("대댓글 생성을 실패했습니다. 대댓글의 id가 없어야 합니다");
        if (commentDto.getBoardId() != board.getBoardId())
            throw new IllegalArgumentException("대댓글 생성을 실패했습니다. 댓글의 id가 없어야 합니다");

        return new Comment(
                commentDto.getId(),
                board,
                commentDto.getNickname(),
                commentDto.getCommentbody(),
                parentComment.getId(),
                commentDto.getCreatedAT(),
                commentDto.getUpdatedAT()
        );
    }


    public void patch(CommentDto commentDto) {
        if (this.id != commentDto.getId())
            throw new IllegalArgumentException("댓글 수정을 실패했습니다. 대상 댓글이 없습니다.");
        // 객체 갱신
        if (commentDto.getNickname() != null)           // 수정할 닉네임 데이터가 있다면
            this.nickname = commentDto.getNickname();   // 내용 반영
        if (commentDto.getCommentbody() != null)               // 수정할 본문 데이터가 있다면
            this.commentbody = commentDto.getCommentbody();           // 내용 반영

        this.updatedAT = LocalDateTime.now();

    }
}

