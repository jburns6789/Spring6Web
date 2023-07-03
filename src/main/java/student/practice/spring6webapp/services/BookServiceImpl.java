package student.practice.spring6webapp.services;

import org.springframework.stereotype.Service;
import student.practice.spring6webapp.domain.Book;
import student.practice.spring6webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    //add constructor parameter
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
