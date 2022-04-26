package dto;

import lombok.Data;

@Data
public class Todo {
	int userId; 
	int id; 
	String title; 
	String completed;
}