package com.conimmuty.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRequestDTO {
    private Long pid;
    private String body;
}
