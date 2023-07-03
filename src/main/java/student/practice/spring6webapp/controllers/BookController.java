package student.practice.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import student.practice.spring6webapp.services.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //when implementing it needs to be an interface
    //An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class
    // implements an interface, thereby inheriting the abstract methods of the interface.
    //Along with abstract methods, an interface may also contain constants, default methods,
    // static methods, and nested types. Method bodies exist only for default methods and static methods.
    //Writing an interface is similar to writing a class. But a class describes the attributes and behaviors of an
    // object. And an interface contains behaviors that a class implements.
    //Unless the class that implements the interface is abstract, all the methods of the interface need to be defined
    // in the class.


    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());

        return "books";
    }
}
