package com.tagir.notes.services;

import com.tagir.notes.entities.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();

    Note addNote(Note note);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);
}
