package com.navneet.library.service;

import com.navneet.library.model.Book;
import com.navneet.library.model.IssuedBooks;
import com.navneet.library.model.Student;
import com.navneet.library.repository.IssueBookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueBookService {

    IssueBookRepository issueBookRepository;

    public IssueBookService(IssueBookRepository issueBookRepository) {
        this.issueBookRepository = issueBookRepository;
    }

    public List<IssuedBooks> getAll() {
        return issueBookRepository.findAll();
    }

    public void issuedBook(IssuedBooks issuedBooks)
    {
        issueBookRepository.save(issuedBooks);
    }

    public List<Book> getBooksForStudent(int id) {

        List<IssuedBooks> list = issueBookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (IssuedBooks b : list){
            if(b.isIssued()&&b.getStudentId()==id)
            {
                final String uri = "http://localhost:8080/books/"+b.getBookId();
                RestTemplate restTemplate = new RestTemplate();
                books.add(restTemplate.getForObject(uri, Book.class));
            }
        }
        return null;
    }

    public Student getStudentForBook(int id) {
        List<IssuedBooks> list = issueBookRepository.findAll();
        for (IssuedBooks b : list) {
            if (b.isIssued() && b.getBookId() == id) {
                final String uri = "http://localhost:8080/students/" + b.getStudentId();
                RestTemplate restTemplate = new RestTemplate();
                return restTemplate.getForObject(uri, Student.class);
            }
        }
        return null;
    }
}
