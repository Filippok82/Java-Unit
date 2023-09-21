package homework04.book;

/*2. У вас есть класс BookService, который использует интерфейс BookRepository для получения
информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя
Mockito для создания мок-объекта BookRepository.
*/


import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BookServiceTest {
    @Test
    public void testFindAllBooks() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        List<Book> expectedBooks = List.of(
                new Book("1","Book1", "Author1"),
                new Book("2","Book2", "Author2")

        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findAllBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void testServiceBook(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        List<Book> expectedBooks = List.of(
                new Book("1","Book1", "Author1"),
                new Book("2","Book2", "Author2")

        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        bookService.findAllBooks();
        bookService.findAllBooks();
        verify(bookRepository, times(2)).findAll();
    }

}