package com.example.spring.di.annotationConfig;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Category {
	@value("456")
	int id;
	
	String name;
	
}
