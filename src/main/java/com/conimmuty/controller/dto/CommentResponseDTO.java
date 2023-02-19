package com.conimmuty.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentResponseDTO {
    private Long cid;
    private Long pid;
    private String body;
    private LocalDateTime createdAt;
}
