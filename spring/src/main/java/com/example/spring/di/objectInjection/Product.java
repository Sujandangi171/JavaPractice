package com.example.spring.di.objectInjection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	int id;
	String name;
	float price;
	Category category;
	

}
