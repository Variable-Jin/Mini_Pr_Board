package com.agile.demo.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Board")
@Setter
@Getter

public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BoardIdx;

    @Column(length = 50, nullable = false)
    private String title ;

    @Column(length = 500, nullable = false)
    private String contents ;

    private LocalDateTime createdAT;
    private LocalDateTime updatedAT;

}
