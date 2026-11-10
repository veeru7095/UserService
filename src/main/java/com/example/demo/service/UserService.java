package com.example.demo.service;

import org.jspecify.annotations.Nullable;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Client.InventoryClient;
import com.example.demo.Dto.InventoryDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Dto.UserProductResponseDto;
import com.example.demo.Repository.UserRepository;
import com.example.demo.entity.UserEntity;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class UserService {
	
	@Autowired
	private final ModelMapper modelMapper;
	@Autowired
	private final UserRepository userRepo;
	
	private final RestTemplate restTemplate;
	
	private final InventoryClient inventoryClient;
	
	public UserService(ModelMapper modelMapper, UserRepository userRepo, RestTemplate restTemplate, InventoryClient inventoryClient) {
		this.modelMapper=modelMapper;
		this.userRepo=userRepo;
		this.restTemplate = restTemplate;
		this.inventoryClient = inventoryClient;
	}

    public UserDto addUser(UserDto usrDto) {
		UserEntity user=modelMapper.map(usrDto, UserEntity.class);
		UserEntity savedUser=userRepo.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}
    
    public UserEntity getUser(Long id) {
    	UserEntity user=userRepo.findById(id).orElseThrow(
    			()-> new RuntimeException("User Not Found with Id "+ id));
    	return user;
    }
    
    public UserProductResponseDto getUserProductById(Long id) {
    	UserEntity user= userRepo.findById(id).orElseThrow(
    			() -> new RuntimeException("User Not Found By id" +id));
    	
    	Long productId=user.getProductId();
    	
    	InventoryDto product=inventoryClient.getProductBYid(productId);
    	
    	UserProductResponseDto response=new UserProductResponseDto();
    	response.setName(user.getName());
    	response.setEmail(user.getEmail());
    	response.setAge(user.getAge());
    	response.setAddress(user.getAddress());
    	response.setProduct(product);
    	
    	return response;    	
    }
    
    
    @Retry(name="InventoryService")
    public InventoryDto getProduct(Long id) {
    	System.out.println("calling inventory service......");
    	
    	return inventoryClient.getProductBYid(id);
    }
    
	
}
