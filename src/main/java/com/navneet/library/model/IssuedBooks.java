package com.navneet.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Issued_books")
public class IssuedBooks {
    @Id
    private int id;
    private int studentid;
    private int bookid;
    private int isIssued;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(int isIssued) {
        this.isIssued = isIssued;
    }
}
