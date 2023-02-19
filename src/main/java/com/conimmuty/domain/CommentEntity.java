package com.conimmuty.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comment")
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private Long pid;

    private String body;

    private LocalDateTime createdAt;

    public CommentEntity(Long pid, String body) {
        this.pid = pid;
        this.body = body;
        this.createdAt = LocalDateTime.now();
    }
}
