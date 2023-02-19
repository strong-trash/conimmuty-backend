package com.conimmuty.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {
    public Long cid;
    public Long pid;
    public String body;
    public LocalDateTime createdAt;
}
