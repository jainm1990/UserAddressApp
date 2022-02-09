package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public ResponseEntity<List<User>> getAllUsers() {

		try {

			List<User> users = new ArrayList<User>();
			userRepository.findAll().forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public User getUser(Long id) {
		
		return userRepository.findById(id).get();
		
	}

	public ResponseEntity<User> addUser(@RequestBody User user) {
		try {
			System.out.println("inside add user");
			User createUser = new User();
			createUser.setFirstName(user.getFirstName());
			createUser.setLastName(user.getLastName());
			User user_created = userRepository.save(createUser);
			System.out.println("user :"+user_created);
			return new ResponseEntity<>(user_created, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity<Set<Address>> getAllAddress(Long id) {
		
		Set<Address> addresslist = userRepository.findById(id).get().getAddress();
		
		for(Address add : addresslist) {
			System.out.println(add);
		}
		
		return new ResponseEntity<>(addresslist, HttpStatus.OK);
		
	}

}
