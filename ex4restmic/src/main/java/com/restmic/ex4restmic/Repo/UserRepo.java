package com.restmic.ex4restmic.Repo;



import org.springframework.data.repository.CrudRepository;


import com.restmic.ex4restmic.Model.User;


public interface UserRepo extends CrudRepository<User,Long> {

   
}
