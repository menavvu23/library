package com.navneet.library.controller;

import com.navneet.library.model.Book;
import com.navneet.library.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/books")
    public boolean createBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return true;
    }
}
