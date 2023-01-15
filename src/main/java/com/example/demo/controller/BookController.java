package com.example.demo.controller;


import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * This will post book
     *
     * @param bookDto
     * @return
     */
    @PostMapping("/book")
    public ResponseEntity<BookDto> postBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.postBook(bookDto));
    }

    /**
     * This will get book by id
     *
     * @param id
     * @return
     */
    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    /**
     * This will get book  by id
     *
     * @return
     */
    @GetMapping("/book")
    public ResponseEntity<List<BookDto>> getAllBook() {
        return ResponseEntity.ok(bookService.getAllBook());
    }

    /**
     * This will update book by id
     *
     * @param id
     * @param bookDto
     * @return
     */
//    @PutMapping("/book/{id}")
//    public ResponseEntity<BookDto> updateBookById(@PathVariable Long id, @RequestBody BookDto bookDto) {
//        return ResponseEntity.ok(bookService.updateBookById(id, bookDto));
//    }

    /**
     * This will delete book by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {

            bookService.deleteBookById(id);
            return ResponseEntity.ok().build();

    }

}
