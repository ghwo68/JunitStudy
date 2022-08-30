package com.study.junitpra.entity;

import com.study.junitpra.controller.dto.BookReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 20, nullable = false)
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void update(String title, String author){
        this.title = title;
        this.author = author;
    }
}
