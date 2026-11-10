package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private int age;
	
	private String address;

	private int productId;
	
	

}
