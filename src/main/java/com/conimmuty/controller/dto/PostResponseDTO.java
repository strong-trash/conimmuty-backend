package com.conimmuty.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {
    public Long pid;
    public String title;
    public String content;
    public Integer likeCnt;
    public Integer dislikeCnt;
    public Integer commentCnt;
    public LocalDateTime createdAt;
}
