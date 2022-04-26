package movie.dto;

import lombok.Data;

//
//insert into 영화(번호, 이름, 개봉연도, 관객수, 평점)
//values(
//	15,
//	'기생충',
//	2020,
//	2700000, 
//	9.15     
//);
//
//insert into 배우(번호, 이름, 출생, 키, 몸무게) values (
//20, 
//'최우식', 
//timestamp('1990-08-04'),
//178, 
//77
//);
//
//insert into 출연(영화번호, 배우번호, 역할, 역) values(
//15,
//20, 
//1,
//'기우'
//);
@Data
public class RequestMovie {
	private int 영화번호; //(select )  
	private String 영화이름; 
	private int 개봉연도;
	private int 관객수; 
	private double 평점; 
	private int 배우번호; // (select)
	private String 배우이름; 
	private String 출생; 
	private int 키;
	private int 몸무게; 
	// private 영화번호 (select ) 
	// private 배우번호 (select )
	private int 역할 = 1; 
	private String 역; 
}





