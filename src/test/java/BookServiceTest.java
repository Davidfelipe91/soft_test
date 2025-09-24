import com.example.LibraryPruebasSoftware.Models.Book;
import com.example.LibraryPruebasSoftware.Repositories.BookRepository;
import com.example.LibraryPruebasSoftware.Services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

        Optional<Book> result = bookService.getBookById(1L);

        assertTrue(result.isPresent());
        assertEquals("1984", result.get().getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }
}
