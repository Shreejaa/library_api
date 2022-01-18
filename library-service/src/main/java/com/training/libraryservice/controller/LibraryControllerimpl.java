package com.training.libraryservice.controller;

import com.training.libraryservice.entity.*;
import com.training.libraryservice.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;

@Slf4j
@RestController
@RefreshScope
public class LibraryControllerimpl implements LibraryController {

    @Autowired
    LibraryService libraryService;

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Performing get all books operation");
        return libraryService.getAllBooks();
    }

    @Override
    public ResponseEntity<Book> getBookByid(Long id) {
        log.info("Performing get book by id : {}",id);
        return libraryService.getBookById(id);
    }

    @Override
    public ResponseEntity<Book> createBook(Book book) {
        log.info("Performing Create a book {}",book);
        return libraryService.createNewBook(book);
    }

    @Override
    public ResponseEntity<Object> deleteBook(Long id) {
        log.info("Performing Delete a book by id {}",id);
        libraryService.deleteBookById(id);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("Performing get all users {}");
        return libraryService.getAllUsers();
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        log.info("Performing get user by id {}",id);
        return libraryService.getUserById(id);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        log.info("Performing create user {}",user);
        return libraryService.createNewUser(user);
    }

    @Override
    public ResponseEntity<User> updateUser(User user, Long id) {
        log.info("Performing update user details {}",user);
        return libraryService.updateUser(user);
    }

    @Override
    public ResponseEntity<Object> deleteUser(Long id) {
        log.info("Performing delete user by id {}",id);
        libraryService.deleteUserById(id);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Library> issueBookToUser(Long bookid, Long userid) {
        log.info("Issuing book( bookid :{}) to user(userid :{})",bookid,userid);
        return new ResponseEntity<>(libraryService.issueBookToUser(userid,bookid),new HttpHeaders(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> releaseBookFromUser(Long bookid, Long userid) {
        log.info("releasing book(bookid:{}) from user(userid:{})",bookid,userid);
        libraryService.releaseBookForUser(userid,bookid);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<List<Library>> getAllLibrary() {
        return new ResponseEntity(libraryService.getAllLibraryObjects(),new HttpHeaders(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Library>> getAllUsersId(Long userid) {
       return new ResponseEntity(libraryService.getByUserId(userid),new HttpHeaders(),HttpStatus.OK);
    }
}
