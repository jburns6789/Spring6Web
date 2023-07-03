package student.practice.spring6webapp.services;

import student.practice.spring6webapp.domain.Book;

public interface BookService { //implement the interface

    Iterable<Book> findAll();

}
