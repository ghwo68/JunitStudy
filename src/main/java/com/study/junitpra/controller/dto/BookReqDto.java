package com.study.junitpra.controller.dto;

import com.study.junitpra.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookReqDto {
    private String title;
    private String author;

    public Book toEntity(){

        return new Book(
                this.title,
                this.author
        );

    }
}
