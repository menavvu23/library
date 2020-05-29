package com.navneet.library.controller;

import com.navneet.library.model.Book;
import com.navneet.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.POST,value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book )
    {
        bookService.addBook(book);
    }

    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Book> findById(@PathVariable(value = "id") int id)
    {
        return bookService.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteById(@PathVariable(value = "id") int id)
    {
        bookService.deleteById(id);
    }

    @RequestMapping("/searchbypublisher")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Book> findByPublisher(@RequestParam(value = "publisher") String publisher)
    {
        return bookService.findByPublisher(publisher);
    }
}
