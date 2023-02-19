package com.conimmuty.controller.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {
    public String title;
    public String content;
}
