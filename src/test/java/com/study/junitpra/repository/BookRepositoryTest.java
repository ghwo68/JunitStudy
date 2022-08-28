package com.study.junitpra.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//DB와 관련된 컴포넌트만 메모리에 로딩
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    //1. 책 등록
    @Test
    @DisplayName("정상 케이스")
    public void createBook_test() {
        System.out.println("책 등록_test 실행");
    }
    //2. 책 목록 보기

}