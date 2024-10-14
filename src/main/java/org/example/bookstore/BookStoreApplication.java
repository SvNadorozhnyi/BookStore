package org.example.bookstore;

import java.math.BigDecimal;
import org.example.bookstore.model.Book;
import org.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book newBook = new Book();
            newBook.setTitle("A Game of Thrones");
            newBook.setAuthor("George R. R. Martin");
            newBook.setPrice(BigDecimal.valueOf(33.83));
            newBook.setIsbn("0345535529");
            newBook.setDescription("Now the acclaimed HBO series Game of Thrones -"
                    + " the masterpiece that became a cultural phenomenon ");

            bookService.save(newBook);
            System.out.println(bookService.findAll());
        };
    }
}
