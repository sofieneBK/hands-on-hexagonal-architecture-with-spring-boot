package org.example.adapters;

import org.example.entity.Book;
import org.example.mappers.BookMapper;
import org.example.repository.BookRepository;
import org.exemple.data.BookDto;
import org.exemple.ports.spi.BookPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookJpaAdapter implements BookPersistencePort {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto addBook(BookDto bookDto) {

        Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);

        Book bookSaved = bookRepository.save(book);

        return BookMapper.INSTANCE.bookToBookDto(bookSaved);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {

        List<Book> bookList = bookRepository.findAll();

        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
    }

    @Override
    public BookDto getBookById(Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            return BookMapper.INSTANCE.bookToBookDto(book.get());
        }

        return null;
    }
}
