package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
	
	private Long id;
	
	private String productName;
	
	private String description;
	
	private double price;
	
	private int quantity;
	
	private String stockStatus;
	
	private String message;
	
	

}
