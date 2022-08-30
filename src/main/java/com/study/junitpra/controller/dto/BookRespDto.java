package com.study.junitpra.controller.dto;

import com.study.junitpra.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookRespDto {
    private Long id;
    private String title;
    private String author;

    public BookRespDto respDto(Book savedBook){
        this.id = savedBook.getId();
        this.title = savedBook.getTitle();
        this.author = savedBook.getTitle();
        return this;
    }

    public static BookRespDto fromEntity(Book book){

        return new BookRespDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor()
        );
    }
}
