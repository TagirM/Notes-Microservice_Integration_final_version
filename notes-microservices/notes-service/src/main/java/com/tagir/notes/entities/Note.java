package com.tagir.notes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @PrePersist
    private void init(){
        createTime = LocalDateTime.now();
    }

    public Note(String title, String content, LocalDateTime createTime) {
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }
}
