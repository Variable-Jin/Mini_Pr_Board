package com.agile.demo.Entity;


import com.agile.demo.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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

    public static Comment createComment(CommentDto commentDto, Board board) {
        if (commentDto.getId() != null)
            throw new IllegalArgumentException("댓글 생성을 실패했습니다. 댓글의 id가 없어야 합니다.");
        if (commentDto.getBoardId() != board.getBoardId())
            throw new IllegalArgumentException("댓글 생성을 실패했습니다. 게시글의 id가 없어야 합니다.");

        return new Comment(
                commentDto.getId(),
                board,
                commentDto.getNickname(),
                commentDto.getCommentbody()
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


    }
}

