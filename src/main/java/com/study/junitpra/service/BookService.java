package com.study.junitpra.service;

import com.study.junitpra.controller.dto.BookReqDto;
import com.study.junitpra.controller.dto.BookRespDto;
import com.study.junitpra.entity.Book;
import com.study.junitpra.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    //1.책 등록
    @Transactional(rollbackFor = RuntimeException.class)
    public BookRespDto 책등록하기(BookReqDto reqDto){
        Book book = reqDto.toEntity();
        Book savedBook = bookRepository.save(book);

        return new BookRespDto().respDto(savedBook);

//        return BookRespDto.fromEntity(savedBook);
    }

    //2.책 목록보기
    public List<BookRespDto> 책목록보기(){
        return bookRepository.findAll().stream()
                .map(new BookRespDto()::respDto)
                .collect(Collectors.toList());

//        return bookRepository.findAll().stream()
//                .map(BookRespDto::fromEntity)
//                .collect(Collectors.toList());
    }

    //3.책 한권 보기
    public BookRespDto 책한권보기(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()){
            return new BookRespDto().respDto(bookOptional.get());
        } else {
            throw new RuntimeException("해당 아이디를 찾을 수 없습니다.");
        }
    }  // 그냥 optional로 하지말고 위에서 Book book = bookRepository.findById(id).orElseThrow를 던져도 됨

    //4.책 삭제하기
    @Transactional(rollbackFor = RuntimeException.class)
    public void 책삭제하기(Long id){
        bookRepository.deleteById(id);
    }

    //5.책 수정하기
    @Transactional(rollbackFor = RuntimeException.class)
    public void 책수정하기(Long id, BookReqDto reqDto){
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()){
            Book book = bookOptional.get();
            book.update(reqDto.getTitle(), reqDto.getAuthor());
        } else {
            throw new RuntimeException("해당 아이디를 찾을 수 없습니다.");
        }
    }
}
