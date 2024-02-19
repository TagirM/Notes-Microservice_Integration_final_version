package com.tagir.restservice.services;

import com.tagir.restservice.rest.Note;
import com.tagir.restservice.rest.NotesFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestNoteService {

    private final NotesFeignClient notesFeignClient;

    /**
     * Получение всех заметок
     * @param title наименование заметки (при поиске)
     * @return список заметок
     */
    public List<Note> getAllNotes(String title){
        List<Note> notes = notesFeignClient.getAllNotes();
        if (title!=null){
            List<Note> notesResult = new ArrayList<>();
            for (Note note :
                    notes) {
                if (note.getTitle().equals(title)){
                    notesResult.add(note);
                }
            }
            return notesResult;
        }
        return notes;
    }

    /**
     * Получение заметки по номеру id
     * @param id номер заметки в базе данных
     * @return заметка
     */
    public Note getNoteById(Long id){
        return notesFeignClient.getNoteById(id);
    }
}
