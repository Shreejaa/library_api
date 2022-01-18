package com.training.libraryservice.clients.fallback;

import com.training.libraryservice.clients.BookServiceClient;
import com.training.libraryservice.entity.Book;
import com.training.libraryservice.util.ResponseEntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookFallBack implements BookServiceClient {

    private static final String BOOK_SERVICE= "Book";
    @Override
    public ResponseEntity<List<Book>> listBooks() {
        return new ResponseEntityUtil().getServiceUnavailableMessage(BOOK_SERVICE);
    }

    @Override
    public ResponseEntity<Book> getBookById(Long id) {
        return new ResponseEntityUtil().getServiceUnavailableMessage(BOOK_SERVICE);
    }

    @Override
    public ResponseEntity<Book> create(Book book) {
        return new ResponseEntityUtil().getServiceUnavailableMessage(BOOK_SERVICE);
    }

    @Override
    public void updateBook(Book book) {
         new ResponseEntityUtil().getServiceUnavailableMessage(BOOK_SERVICE);
   }

    @Override
    public void deleteBook(Long id) {
         new ResponseEntityUtil().getServiceUnavailableMessage(BOOK_SERVICE);
    }
}
