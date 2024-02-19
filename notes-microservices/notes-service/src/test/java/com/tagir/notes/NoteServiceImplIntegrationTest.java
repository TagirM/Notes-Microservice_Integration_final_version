package com.tagir.notes;

import com.tagir.notes.entities.Note;
import com.tagir.notes.repositories.NoteRepository;
import com.tagir.notes.services.NoteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NoteServiceImplIntegrationTest {
    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteServiceImpl noteServiceImpl;

    @Test
    public void getAllNotes() {
//        pre
        Note note1 = new Note( 1L,"Java", "Finish homework by Java", LocalDateTime.now());
        Note note2 = new Note( 2L,"Spring", "Finish homework by Spring", LocalDateTime.now());
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        when(noteRepository.findAll()).thenReturn(notes);
//        given(noteRepository.findAll()).willReturn(notes);
//        action
        List<Note> notesFromService = noteServiceImpl.getAllNotes();
//        check
        verify(noteRepository).findAll();
        Assertions.assertEquals(notes, notesFromService);
    }

    @Test
    public void getNoteById() {
//        pre
        Note note = new Note( 1L,"Java", "Finish homework by Java", LocalDateTime.now());
//        given(noteRepository.findById(note.getId())).willReturn(Optional.of(note));
        when(noteRepository.findById(note.getId())).thenReturn(Optional.of(note));
//        action
        Optional<Note> optionalNote = noteServiceImpl.getNoteById(1L);
//        check
        verify(noteRepository).findById(1L);
        Assertions.assertEquals(Optional.of(note), optionalNote);
    }

    @Test
    public void updateNote() {
        //        pre
        Note note1 = new Note( 1L,"Java", "Finish homework by Java", LocalDateTime.now());
        Note note2 = new Note( "Python", "Finish homework by Python", LocalDateTime.now());
        note2.setId(note1.getId());
//        given(noteRepository.save(note2)).willReturn(note2);
        when(noteRepository.save(note2)).thenReturn(note2);
//        action
        noteServiceImpl.updateNote(1L, note2);
//        check
        verify(noteRepository).save(note2);
    }
}
