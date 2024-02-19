package com.tagir.restservice.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Класс аналогичный entity в микросервисе notes-service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private Long Id;

    private String title;

    private String content;

    private LocalDateTime createTime;
}
