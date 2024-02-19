package com.tagir.notes;

import com.tagir.notes.entities.Note;
import com.tagir.notes.repositories.NoteRepository;
import com.tagir.notes.services.NoteServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class NoteServiceImplUnitTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteServiceImpl;

    @Test
    public void getAllNotes() {
//        pre
        Note note1 = new Note( 1L,"Java", "Finish homework by Java", LocalDateTime.now());
        Note note2 = new Note( 2L,"Spring", "Finish homework by Spring", LocalDateTime.now());
        List<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        given(noteRepository.findAll()).willReturn(notes);
//        action
        noteServiceImpl.getAllNotes();
//        check
        verify(noteRepository).findAll();
    }

    @Test
    public void getNoteById() {
//        pre
        Note note = new Note( 1L,"Java", "Finish homework by Java", LocalDateTime.now());
        given(noteRepository.findById(note.getId())).willReturn(Optional.of(note));
//        action
        noteServiceImpl.getNoteById(1L);
//        check
        verify(noteRepository).findById(1L);
    }

    @Test
    public void updateNote() {
        //        pre
        Note note1 = new Note( 1L,"Java", "Finish homework by Java", LocalDateTime.now());
        Note note2 = new Note( "Python", "Finish homework by Python", LocalDateTime.now());
        note2.setId(1L);
        given(noteRepository.save(note2)).willReturn(note2);
//        action
        noteServiceImpl.updateNote(1L, note2);
//        check
        verify(noteRepository).save(note2);
    }
}