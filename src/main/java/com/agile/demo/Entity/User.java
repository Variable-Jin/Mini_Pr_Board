package com.agile.demo.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String nickname;

    @ElementCollection(targetClass = String.class)
    @Column(nullable = false)
    private List<String> part;

}
