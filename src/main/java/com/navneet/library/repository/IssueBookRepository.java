package com.navneet.library.repository;

import com.navneet.library.model.IssuedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepository extends JpaRepository<IssuedBooks,Integer> {
}
