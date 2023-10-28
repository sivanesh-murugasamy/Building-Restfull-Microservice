package com.restmic.ex4restmic.Controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restmic.ex4restmic.Model.User;
import com.restmic.ex4restmic.Repo.UserRepo;
import com.restmic.ex4restmic.Service.Userserv;

@RestController
public class UserController {
    
   @Autowired
   UserRepo userRepo;

   @Autowired
   Userserv userServ;
   
   @GetMapping("/all")
   public List <User> getByCategory()
   {
    return (ArrayList <User>) userRepo.findAll();
      }
   @PostMapping("/insert")
   public String insertUser(@RequestBody User user)
   {
    userRepo.save(user);
    return "Inserted Successfully";
   }
   @PutMapping("/update/user{id}")
   public String updateUser(@PathVariable long id,@RequestBody User user)
   {
    user.setId(id);
    userServ.updateUser(id,user);
    return "Updated Successfully";
   }
   @DeleteMapping("/delete/user{id}")
   public String deleteUser(@PathVariable long id)
   {
    userServ.deleteUser(id);
    return "Deleted";
   }
   @GetMapping("display/user{id}")
   public Optional<User> getById(@PathVariable long id)
   {
    Optional <User> user=userServ.getUserById(id);
    return user;
   }
}
