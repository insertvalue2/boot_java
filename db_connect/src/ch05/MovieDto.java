package ch05;

import lombok.Data;

/**
 * @author ITPS
 * 이름, 개봉연도, 매출액, 관객수, 평정,
 * 역, 이름  
 */
@Data
public class MovieDto {
	private String movieName; 
	private String year; 
	private String sales; 
	private String audience;
	private String rating; 
	private String roleName; 
	private String name; 
}
