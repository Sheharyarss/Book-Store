//package com.example.demo.service;
//
//import com.example.demo.dto.BookDto;
//import com.example.demo.model.Book;
//import com.example.demo.repository.BookRepo;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class BookServiceTest {
//
//    @Mock
//    private BookRepo    bookRepo;
//    @Mock
//    private Book        book;
//    @Mock
//    private BookDto     bookDto;
//    @Mock
//    private ModelMapper modelMapper;
//    @InjectMocks
//    private BookService bookService;
//
//    @Test
//    public void shouldGetAllBooks() {
//        when(bookRepo.findAll()).thenReturn(Arrays.asList(book));
//        when(modelMapper.map(book, BookDto.class)).thenReturn(bookDto);
//
//        List<BookDto> bookDtos = bookService.getAllBook();
//        Assertions.assertNotNull(bookDtos);
//
//        verify(bookRepo).findAll();
//        verify(modelMapper).map(book, BookDto.class);
//    }
//
//    @Test
//    public void shouldGetBookById() {
//        when(bookRepo.findById(anyLong())).thenReturn(Optional.of(book));
//        when(modelMapper.map(book, BookDto.class)).thenReturn(bookDto);
//
//        BookDto bookDtos = bookService.getBookById(anyLong());
//        Assertions.assertNotNull(bookDtos);
//
//        verify(bookRepo).findById(anyLong());
//        verify(modelMapper).map(book, BookDto.class);
//    }
//
//    @Test
//    public void shouldDeleteBookById() {
//        when(bookRepo.findById(anyLong())).thenReturn(Optional.of(book));
//        doNothing().when(bookRepo).deleteById(anyLong());
//
//        bookService.deleteBookById(anyLong());
//
//        verify(bookRepo).findById(anyLong());
//        verify(bookRepo).deleteById(anyLong());
//    }
//
//    @Test
//    public void shouldUpdateBook() {
//        when(bookRepo.findById(anyLong())).thenReturn(Optional.of(book));
//        when(bookRepo.save(book)).thenReturn(book);
//        when(modelMapper.map(book, BookDto.class)).thenReturn(bookDto);
//
//        bookService.updateBookById(anyLong(), bookDto);
//
//        verify(bookRepo).findById(anyLong());
//        verify(bookRepo).save(book);
//        verify(modelMapper).map(book, BookDto.class);
//    }
//
//    @Test
//    public void shouldNotUpdateBook() {
//        when(bookRepo.findById(anyLong())).thenReturn(Optional.empty());
//
//        Assertions.assertNull(bookService.updateBookById(anyLong(), bookDto));
//
//        verify(bookRepo).findById(anyLong());
//        verifyNoInteractions(modelMapper);
//    }
//
//    @Test
//    public void shouldPostBooks() {
//
//        when(modelMapper.map(bookDto, Book.class)).thenReturn(book);
//        when(bookRepo.save(book)).thenReturn(book);
//        when(modelMapper.map(book, BookDto.class)).thenReturn(bookDto);
//
//        BookDto bookDtos = bookService.postBook(bookDto);
//        Assertions.assertNotNull(bookDtos);
//
//        verify(modelMapper).map(bookDto, Book.class);
//        verify(bookRepo).save(book);
//        verify(modelMapper).map(book, BookDto.class);
//    }
//
//
//}
