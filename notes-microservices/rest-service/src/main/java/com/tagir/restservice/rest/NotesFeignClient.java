package com.tagir.restservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "notes-service")
public interface NotesFeignClient {

    /**
     * Обращение к контроллеру в микросервисе notes-service за всем списком заметок
     * @return список заметок
     */
    @RequestMapping(value = "/notes-service", method = RequestMethod.GET)
    List<Note> getAllNotes();

    /**
     * Обращение к контроллеру в микросервисе notes-service за заметкой по номеру id
     * @return заметка
     */
    @RequestMapping(value = "/notes-service/{noteId}", method = RequestMethod.GET)
    Note getNoteById(@PathVariable(name = "noteId") Long noteId);
}
