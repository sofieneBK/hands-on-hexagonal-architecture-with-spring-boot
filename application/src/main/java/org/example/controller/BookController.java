package org.example.controller;

import org.exemple.data.BookDto;
import org.exemple.ports.api.BookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServicePort bookServicePort;

    @PostMapping("/add")
    public BookDto addBook(@RequestBody BookDto bookDto) {
        return bookServicePort.addBook(bookDto);
    }

    @PutMapping("/update")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookServicePort.updateBook(bookDto);
    }

    @GetMapping("/get/{id}")
    public BookDto getBookByID(@PathVariable long id) {
        return bookServicePort.getBookById(id);
    }

    @GetMapping("/get")
    public List<BookDto> getAllBooks() {
        return bookServicePort.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookByID(@PathVariable long id) {
        bookServicePort.deleteBookById(id);
    }
}
