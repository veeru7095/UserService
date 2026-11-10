package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.InventoryDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Dto.UserProductResponseDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/register")
	public UserDto addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}
	
	@GetMapping("/getUser/{id}")
	public UserEntity getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/getProduct/{id}")
	public UserProductResponseDto getProduct(@PathVariable Long id) {
		return userService.getUserProductById(id);
	}
	
	 @GetMapping("/product/{id}")
	    public InventoryDto get(
	            @PathVariable Long id) {

	        return userService.getProduct(id);
	    }
	
}
