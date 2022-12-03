package com.futureengineers.restapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
