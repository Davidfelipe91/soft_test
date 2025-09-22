package com.example.LibraryPruebasSoftware.Controllers;

import com.example.LibraryPruebasSoftware.Models.Book;
import com.example.LibraryPruebasSoftware.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookServicio) {
        this.bookService = bookServicio;
    }

    // GET: Listar todos
    @GetMapping
    public List<Book> BookList() {
        return bookService.getAllBooks();
    }

    // GET: Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Guardar
    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // PUT: Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.updateBook(id, book));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok().build();
    }
}
