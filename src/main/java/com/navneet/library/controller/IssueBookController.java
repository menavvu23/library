package com.navneet.library.controller;

import com.navneet.library.model.Book;
import com.navneet.library.model.IssuedBooks;
import com.navneet.library.model.Student;
import com.navneet.library.service.IssueBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueBookController {

    IssueBookService issueBookService;


    public IssueBookController(IssueBookService issueBookService) {
        this.issueBookService = issueBookService;
    }

    @RequestMapping("/issuedbooks")
    @ResponseStatus(HttpStatus.OK)
    public List<IssuedBooks> getAllIssuedBooks()
    {
        return issueBookService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/issuedbooks")
    @ResponseStatus(HttpStatus.CREATED)

    public void issueBook(@RequestBody IssuedBooks issuedBooks)
    {
        issueBookService.issuedBook(issuedBooks);
    }

    @RequestMapping("/issuedbooks/student/{id}")
    public List<Book>  getBooksForStudent(@PathVariable(value ="id") int id)
    {
        return issueBookService.getBooksForStudent(id);
    }
    @RequestMapping("/issuedbooks/book/{bookid}")
    public Student getStudentForBook(@PathVariable(value = "bookid") int id)
    {
        return issueBookService.getStudentForBook(id);
    }
}
