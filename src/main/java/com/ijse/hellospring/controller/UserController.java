package com.ijse.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.entity.User;
import com.ijse.hellospring.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")//allow a request came from any origine
public class UserController {

   @Autowired
   private UserService userService;

   @GetMapping("/users")
   public List<User> getAllUsers() {
       return userService.getAllUsers();
   }

   @GetMapping("/users/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id) {
       User user = userService.getUserById(id);

       if(user == null){
        return ResponseEntity.status(404).build();
       }else{
        return ResponseEntity.status(200).body(user);
       }
   }
   
   @PostMapping("/users")
   public ResponseEntity<User> creatUser(@RequestBody User user) {
       User createUser = userService.createUser(user);
       return ResponseEntity.status(201).body(createUser);
   }
   
   @PutMapping("users/{id}")
   public User updatUser(@PathVariable Long id, @RequestBody User user) {
       return userService.updateUser(id, user);
   }

   @DeleteMapping("users/{id}")
   public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
   }

}
