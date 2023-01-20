package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.notfound;
import com.example.demo.dao.user;
import com.example.demo.repositary.userrepositary;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class usercontroller {
	
	@Autowired
	
	private userrepositary userrepo;
	
	@GetMapping("/User")
	public List<user> getAllUser(){
		
		return userrepo.findAll();
	}
		@PostMapping("/User")
	public ResponseEntity<user> createuser(@RequestBody user us) {
			user us1= userrepo.save(us);
			return new ResponseEntity<user>(us1, HttpStatus.CREATED);
	}
	@GetMapping("/User/{id}")
	public ResponseEntity<user> getUserId(@PathVariable int id) {
		user us=userrepo.findById(id).orElseThrow(()->new notfound("User is does not id:"+id));
		return ResponseEntity.ok(us);
	}
	
	@PutMapping("/User/{id}")
	public ResponseEntity<user> updateUser(@PathVariable int id,@RequestBody user us) {
		user us1=userrepo.findById(id).orElseThrow(()->new notfound("User is does not id:"+id));
		us1.setEmail(us.getEmail());
		us1.setFirstname(us.getFirstname());
		us1.setLastname(us.getLastname());
		us1.setAge(us.getAge());
		user update=userrepo.save(us1);
		return ResponseEntity.ok(update);
}
	@DeleteMapping("/User/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteUser(@PathVariable int id){
		user us1=userrepo.findById(id).orElseThrow(()->new notfound("User is does not id:"+id));
		userrepo.delete(us1);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
