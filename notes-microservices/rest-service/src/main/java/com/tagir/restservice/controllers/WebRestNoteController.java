package com.tagir.restservice.controllers;

import com.tagir.restservice.rest.Note;
import com.tagir.restservice.services.RestNoteService;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rest-service")
public class WebRestNoteController {

    private final RestNoteService restNoteService;

    private final MeterRegistry meterRegistry;
    /**
     * Главная страница со всеми заметками, а также с поиском по названию
     * @param title Название заметки
     * @param model Модель
     * @return Главная страница
     */
    @GetMapping
    public String getNotes(@RequestParam(name = "search", required = false) String title, Model model) {
        meterRegistry.counter("required_getNotes_counters").increment();
        model.addAttribute("results", restNoteService.getAllNotes(title));
        model.addAttribute("search", title);
        return "notes";
    }

    /**
     * Карточка заметки
     * @param id Заметка по id
     * @param model Модель
     * @return Страница с выбранной заметкой, показывающая всю информацию из заметки
     */
    @GetMapping("/{id}")
    public String getNoteInfo(@PathVariable Long id, Model model) {
        Note note = restNoteService.getNoteById(id);
        model.addAttribute("result", note);
        return "note-info";
    }

}
