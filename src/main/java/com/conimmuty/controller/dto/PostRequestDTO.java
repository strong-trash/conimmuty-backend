package com.conimmuty.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class PostRequestDTO {
    private String title;
    private String content;
}
