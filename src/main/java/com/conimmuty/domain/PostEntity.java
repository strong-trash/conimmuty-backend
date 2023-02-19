package com.conimmuty.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "post")
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String title;
    private String content;
    private Integer likeCnt;
    private Integer dislikeCnt;
    private Integer commentCnt;
    private LocalDateTime createdAt;

    public PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
        this.likeCnt = 0;
        this.dislikeCnt = 0;
        this.commentCnt = 0;
        this.createdAt = LocalDateTime.now();
    }
}
