package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProductResponseDto {

	private String name;
	
	private String email;
	
	private int age;
	
	private String address;
	
	private InventoryDto product;
	
}
