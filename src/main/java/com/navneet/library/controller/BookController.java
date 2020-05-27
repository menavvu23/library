package com.navneet.library.controller;

import com.navneet.library.model.Book;
import com.navneet.library.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    
    @RequestMapping("/books/{id}")
    public Book findABook(@PathVariable(value = "id") int id)
    {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }
}
