package com.example.spring.di.annotationConfig;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
	int id;
	String name;
	float price;
	Category category;
	

}
