package com.example.spring.di.literals;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataAccessObject {
	String url;
	String driver;
	String username;
	String password;
	
	
}
