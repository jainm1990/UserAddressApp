package com.example.demo.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;
import com.example.demo.model.Address;
import com.example.demo.model.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("inside getuserss");
		return userService.getAllUsers();
	}
	
	

	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Set<Address>> getAddressForUser(@PathVariable String userId) {
		return userService.getAllAddress(Long.valueOf(userId));
		
	}
	
	@PostMapping("/user/address/{userId}")
	public void addAddress(@PathVariable String userId,  @RequestBody Address address) {
		
		User user = userService.getUser(Long.valueOf(userId));
		if(user != null) {			
			address.setUser(user);
			addressService.addAddress(address);
		}
		
	}
	
	@PutMapping("/user/address/{addressId}")
	public void updateAddress(@PathVariable String addressId,  @RequestBody Address address) {
			
			addressService.updateAddress(Long.valueOf(addressId), address);
		
	}
	
	@DeleteMapping("/user/address/{addressId}")
	public void deleteAddress(@PathVariable String addressId) {
			
			addressService.deleteAddress(Long.valueOf(addressId));
		
	}

//		@RequestMapping(method = RequestMethod.PUT, value="/subjects/{id}")
//		public void updateSubject(@PathVariable String id, @RequestBody Subject subject)
//		{
//			subjectService.updateSubject(id, subject);
//		}
//		@RequestMapping(method = RequestMethod.DELETE, value="/subjects/{id}")
//		public void DeleteSubject(@PathVariable String id)
//		{
//			subjectService.deleteSubject(id);
//		}

}
