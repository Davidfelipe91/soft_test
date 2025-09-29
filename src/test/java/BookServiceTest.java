import com.example.LibraryPruebasSoftware.Models.Book;
import com.example.LibraryPruebasSoftware.Repositories.BookRepository;
import com.example.LibraryPruebasSoftware.Services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testGetBooks() {
        Book b1 = new Book("Cien Años de Soledad", "Gabriel García Márquez", "1967");
        Book b2 = new Book("El Quijote", "Miguel de Cervantes", "1605");

        when(bookRepository.findAll()).thenReturn(Arrays.asList(b1, b2));

        List<Book> booksList = bookService.getAllBooks();
        assertEquals(2, booksList.size());
        assertEquals("Cien Años de Soledad", booksList.get(0).getTitle());

        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testGetBookById() {
        Book b1 = new Book("1984", "George Orwell", "1949");
        Book b2 = new Book("El Hueco", "Forrest Gump", "1956");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(b1));

        Optional<Book> bookResult = bookService.getBookById(1L);
        assertTrue(bookResult.isPresent());
        assertEquals("1984", bookResult.get().getTitle());

        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveBook() {
        Book b1 = new Book("Fahrenheit 451", "Ray Bradbury", "1953");
        Book b2 = new Book("El Junco", "Teresa Valencia", "1985");

        when(bookRepository.save(b1)).thenReturn(b1);

        Book savedBook = bookService.saveBook(b1);
        assertNotNull(savedBook);
        assertEquals("Fahrenheit 451", savedBook.getTitle());

        verify(bookRepository, times(1)).save(b1);
    }

    @Test
    void testUpdateBook() {
        Book currentBook = new Book("Viejo título", "Autor X", "1900");
        Book updatedBook = new Book("Nuevo título", "Autor Y", "2000");

        this.testGetBookById();

        when(bookRepository.findById(1L)).thenReturn(Optional.of(currentBook));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);

        Book bookResult = bookService.updateBook(1L, updatedBook);
        assertEquals("Nuevo título", bookResult.getTitle());
        assertEquals("Autor Y", bookResult.getAuthor());
        assertEquals("2000", bookResult.getIsbn());

        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}
