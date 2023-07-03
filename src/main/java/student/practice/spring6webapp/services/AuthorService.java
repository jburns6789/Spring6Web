package student.practice.spring6webapp.services;

import student.practice.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
 }
