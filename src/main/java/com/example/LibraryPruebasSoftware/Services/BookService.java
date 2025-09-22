package com.example.LibraryPruebasSoftware.Services;

import com.example.LibraryPruebasSoftware.Models.Book;
import com.example.LibraryPruebasSoftware.Repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // Inyectar la capa de Repositorio del libro
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // Métodos para el CRUD
    // Recuperar todos los libros
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    // Recuperar un libro por id
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
    // Guardar un libro
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
    // Eliminar un libro
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    //Update
    public Book updateBook(Long id, Book book) {
        return bookRepository.findById(id)
                .map(b -> {
                    b.setTitle (book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setIsbn(book.getIsbn());
                    return bookRepository.save(b);
                })
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
    }
}
