package com.training.libraryservice.service;

import com.training.libraryservice.entity.Book;
import com.training.libraryservice.LibraryRepository;
import com.training.libraryservice.clients.BookServiceClient;
import com.training.libraryservice.clients.UserServiceClient;
import com.training.libraryservice.entity.Library;
import com.training.libraryservice.entity.User;
import com.training.libraryservice.exception.LibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookServiceClient bookServiceClient;

    @Autowired
    UserServiceClient userServiceClient;

    public ResponseEntity<List<Book>> getAllBooks(){
        return bookServiceClient.listBooks();
    }

    public ResponseEntity<Book> getBookById(Long id){
        return bookServiceClient.getBookById(id);
    }

    public ResponseEntity<Book> createNewBook(Book book){
        return bookServiceClient.create(book);
    }

    public void deleteBookById(Long id){
         bookServiceClient.deleteBook(id);
    }

    public ResponseEntity<List<User>> getAllUsers(){
        return userServiceClient.getUsers();
    }

    public ResponseEntity<User> getUserById(Long id){
        return userServiceClient.getUserById(id);
    }

    public ResponseEntity<User> createNewUser(User user){
        return userServiceClient.createUser(user);
    }

    public void deleteUserById(Long id){
        userServiceClient.deleteUser(id);
    }

    public ResponseEntity<User> updateUser(User user){
        return userServiceClient.updateUser(user);
    }

    public Library issueBookToUser(Long userid,Long bookid)  {

        Library library;
         library = new Library();
            library.setBookid(bookid);
            library.setUserid(userid);
            return libraryRepository.save(library);

    }

    public List<Library> getAllLibraryObjects(){
        return libraryRepository.findAll();
    }

    public List<Library> getByUserId(Long userid){
        return libraryRepository.findByUserid(userid);
    }

    public Long findLibraryByUserIdAndBookId(Long userId,Long bookid) {
        List<Library> list = libraryRepository.findAll();
        Library library=new Library();
        if(list.size()>0) {
            for (Library item : list) {
                if (item.getUserid() == userId && item.getBookid() == bookid) {
                    library = item;
                }
            }
        }
        return library.getId();
    }

    public void releaseBookForUser(Long userid,Long bookid) {
      try {
            Long libId = findLibraryByUserIdAndBookId(userid, bookid);
                if (libId > 0) {
                    libraryRepository.deleteById(libId);
                }
           else {
                throw new LibraryException("No such library created");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

}
