package student.practice.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import student.practice.spring6webapp.domain.Author;
import student.practice.spring6webapp.domain.Book;
import student.practice.spring6webapp.domain.Publisher;
import student.practice.spring6webapp.repositories.AuthorRepository;
import student.practice.spring6webapp.repositories.BookRepository;
import student.practice.spring6webapp.repositories.PublisherRepository;

@Component //annotating as a component
public class BootstrapData implements CommandLineRunner {

    //cmd+n select implement methods and select run
    //this will run when ever spring boot starts

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    //only constructor on the class

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setISBN("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);



        Author jeff = new Author();
        jeff.setFirstName("Jeffrey");
        jeff.setLastName("Friedl");

        Book re = new Book();
        re.setTitle("Mastering Regular Expressions");
        re.setISBN("678910");

        Author jeffSaved = authorRepository.save(jeff);
        Book reSaved = bookRepository.save(re);




        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Pearson");
        publisher1.setAddress("1234 London Drive");
        publisher1.setCity("London");
        publisher1.setState("Ohio");
        publisher1.setZip("44215");

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Harper Collins");
        publisher2.setCity("New York");
        publisher2.setState("New York");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        Publisher savedPublisher = publisherRepository.save(publisher1);
        Publisher savedPublisher2 = publisherRepository.save(publisher2);


//creating an association between author and book here,developing relationships
        ericSaved.getBooks().add(dddSaved);
        jeffSaved.getBooks().add(reSaved);

        dddSaved.setPublisher(savedPublisher);
        reSaved.setPublisher(savedPublisher2);


        //persist the objects
        authorRepository.save(ericSaved);
        authorRepository.save(jeffSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(reSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count : " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }

}
