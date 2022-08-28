package com.study.junitpra.repository;

import com.study.junitpra.entity.Book;
import org.apache.el.stream.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;

//DB와 관련된 컴포넌트만 메모리에 로딩
@DataJpaTest
class BookRepositoryTest {

    //DI
    @Autowired
    private BookRepository bookRepository;

//    @BeforeAll //테스트 시작전에 한번만 실행
    @BeforeEach //각 테스트 시작전에 한번씩 실행
    public void 데이터준비(){
        String title = "Junit5";
        String author = "Hojae";

        Book book = new Book(title, author);
        bookRepository.save(book);
    }

    //1. 책 등록
    @Test
//    @DisplayName("정상 케이스")
    public void 책등록_test() {

        //given(데이터 준비)
        String title = "Junit";
        String author = "Ho";

        Book book = new Book(title,author);

        //when(테스트 실행)
        Book savedBook = bookRepository.save(book);

        //then(검증)
        assertEquals(title, savedBook.getTitle());
        assertEquals(author, savedBook.getAuthor());
    }
    //2. 책 목록 보기
    @Test
//    @DisplayName("정상 케이스")
    public void 책목록보기_test(){

        //given
        String title = "Junit5";
        String author = "Hojae";

        //when
        List<Book> books = bookRepository.findAll();

        //then
        assertEquals(title, books.get(0).getTitle());
        assertEquals(author,books.get(0).getAuthor());
    }

    //3.책 한권보기
    @Test
    public void 책한권보기_test(){

        //given
        String title = "Junit5";
        String author = "Hojae";

        //when
        Book bookById = bookRepository.findById(1L).orElse(null); //.get()을 하니까 오류 -> 왜 null값이 뜨지? id를 왜 못가져오지?

        //then
        assertEquals(title, bookById.getTitle());
        assertEquals(author,bookById.getAuthor());
    }

    //4. 책 삭제
    @Test
    public void 책_삭제(){

        //given
        Long id = 1L;

        //when
        bookRepository.deleteById(id);

        //then
        assertFalse(null,bookRepository.findById(id).isPresent());
    }

}