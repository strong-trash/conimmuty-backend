package com.conimmuty.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostResponseDTO {
    private Long pid;
    private String title;
    private String content;
    private Integer likeCnt;
    private Integer dislikeCnt;
    private Integer commentCnt;
    private LocalDateTime createdAt;
}
