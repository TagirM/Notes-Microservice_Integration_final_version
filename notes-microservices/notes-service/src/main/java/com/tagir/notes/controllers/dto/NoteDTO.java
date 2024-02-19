package com.tagir.notes.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {

    private String title;

    private String content;

    private LocalDateTime createTime = LocalDateTime.now();

}
