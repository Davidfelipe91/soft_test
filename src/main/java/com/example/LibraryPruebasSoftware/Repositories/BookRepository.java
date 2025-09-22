package com.example.LibraryPruebasSoftware.Repositories;

import com.example.LibraryPruebasSoftware.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
