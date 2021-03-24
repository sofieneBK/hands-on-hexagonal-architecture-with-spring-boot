package org.exemple.ports.api;

import org.exemple.data.BookDto;

import java.util.List;

public interface BookServicePort {

    BookDto addBook(BookDto bookDto);

    void deleteBookById(Long id);

    BookDto updateBook(BookDto bookDto);

    List<BookDto> getBooks();

    BookDto getBookById(Long bookId);
}
