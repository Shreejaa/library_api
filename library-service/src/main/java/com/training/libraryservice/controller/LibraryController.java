package com.training.libraryservice.controller;

import com.training.libraryservice.entity.*;
import com.training.libraryservice.entity.Library;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/library")
@Api(value = "Library Resource",description = "uses books api and users api")
public interface LibraryController {

    @ApiOperation(value="get all books ", response = Library.class)
    @GetMapping("/books/all")
    public ResponseEntity<List<Book>> getAllBooks();

    @ApiOperation(value = "getbook by id",response = Library.class)
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookByid(
            @ApiParam(value ="Book id", required = true) @PathVariable Long id);

    @ApiOperation(value = "create new book",response = Library.class)
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(Book book);

    @ApiOperation(value="delete a book", response = Library.class)
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@ApiParam(value = "book id", required = true) @PathVariable Long bookid);

    @ApiOperation(value="get all users",response = Library.class)
    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers();

    @ApiOperation(value = "get user by id", response = Library.class)
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@ApiParam(value = "user id", required = true) @PathVariable Long userid);

    @ApiOperation(value="create new user ",response = Library.class)
    @PostMapping("/users")
    public ResponseEntity<User> createUser(User user);

    @ApiOperation(value="update user by id", response = Library.class)
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(User user,@ApiParam(value = "user id", required = true) @PathVariable Long userid);

    @ApiOperation(value="delete a user" , response = Library.class)
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@ApiParam(value = "user id", required = true) @PathVariable Long userid);

    @ApiOperation(value="issue a book to user",response = Library.class)
    @PutMapping("/books/{bookid}/users/{userid}")
    public ResponseEntity<Library> issueBookToUser(
            @ApiParam(value = "book id", required = true) @PathVariable Long bookid,
            @ApiParam(value = "user id", required = true) @PathVariable Long userid);

    @ApiOperation(value = "release a book from user",response = Library.class)
    @DeleteMapping("/books/{bookid}/users/{userid}")
    public ResponseEntity<Object> releaseBookFromUser(
            @ApiParam(value = "book id", required = true) @PathVariable Long bookid,
            @ApiParam(value = "user id", required = true) @PathVariable Long userid);

    @ApiOperation(value="get all Library items ", response = Library.class)
    @GetMapping()
    public ResponseEntity<List<Library>> getAllLibrary();

    @ApiOperation(value="get all Library items ", response = Library.class)
    @GetMapping("/users/id")
    public ResponseEntity<List<Library>> getAllUsersId(
            @ApiParam(value = "user id", required = true) @PathVariable Long userid
    );


}
