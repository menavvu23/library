package com.navneet.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Issued_books")
public class IssuedBooks {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty
    private boolean issued;
    private int bookId;
    private int studentId;

    public int getId() {
        return id;
    }
    //
     
    //

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studenIid) {
        this.studentId = studenIid;
    }
}
