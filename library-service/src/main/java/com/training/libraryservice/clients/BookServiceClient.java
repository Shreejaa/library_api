package com.training.libraryservice.clients;


import com.training.libraryservice.entity.Book;
import com.training.libraryservice.clients.fallback.BookFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@FeignClient(name = "book-service",fallback = BookFallBack.class)
public interface BookServiceClient {

    @GetMapping("/books")
    ResponseEntity<List<Book>> listBooks();

    @GetMapping("/books/{id}")
    ResponseEntity<Book> getBookById(@PathVariable Long id);

    @PostMapping("/books")
    ResponseEntity<Book> create(@RequestBody Book book);

    @PutMapping("/books/{id}")
    void updateBook(@RequestBody Book book);

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id);

}
