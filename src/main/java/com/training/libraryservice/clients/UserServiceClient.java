package com.training.libraryservice.clients;


import com.training.libraryservice.clients.fallback.UserFallBack;
import com.training.libraryservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service",fallback = UserFallBack.class)
public interface UserServiceClient {

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers();

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id);

    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody User user);

    @PutMapping("/users/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user);

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id);

}
