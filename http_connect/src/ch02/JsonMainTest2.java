package ch02;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Todo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 
 * 
[
	
	{
		"name": "홍길동"
		"age" : 20, 
		"address" : "부산"
	},
	{
		"name": "이순신"
		"age" : 33, 
		"address" : "서울"
	},
	{
		"name": "세종대왕"
		"age" : 59, 
		"address" : "세종시"
	}
]
 *
 */


@AllArgsConstructor
class Student {
	String name; 
	int age; 
	String address;
}


public class JsonMainTest2 {

	public static void main(String[] args) {
		
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 30, "서불");
		Student student3 = new Student("세종대왕", 59, "세종시");
		
		// Object ---> 형식이 있는 문자열로 변환 (JSON) 
		Gson gson = new Gson();
		// 1 단계 연습 
		String jsonStr = gson.toJson(student1);
		System.out.println(jsonStr);
		
	
		// ArrayList<Object> --> JSONArray[JSONObject]
		// 2단계 연습
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		String jsonArrayStr = gson.toJson(list);
		System.out.println(jsonArrayStr);
		
	}

}
