package com.training.libraryservice.clients.fallback;

import com.training.libraryservice.clients.UserServiceClient;
import com.training.libraryservice.entity.User;
import com.training.libraryservice.util.ResponseEntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFallBack implements UserServiceClient {
    private static final String USER_SERVICE="User";
    @Override
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntityUtil().getServiceUnavailableMessage(USER_SERVICE);
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        return new ResponseEntityUtil().getServiceUnavailableMessage(USER_SERVICE);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        return new ResponseEntityUtil().getServiceUnavailableMessage(USER_SERVICE);
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        return new ResponseEntityUtil().getServiceUnavailableMessage(USER_SERVICE);
    }

    @Override
    public void deleteUser(Long id) {
         new ResponseEntityUtil().getServiceUnavailableMessage(USER_SERVICE);
  }
}
