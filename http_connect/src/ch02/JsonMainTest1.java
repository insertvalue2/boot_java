package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest1 {

	public static void main(String[] args) {
		// 2.
		// JSONObject 만드는 방법

		JsonObject jsonObj1 = new JsonObject();

		jsonObj1.addProperty("이름", "홍길동");
		jsonObj1.addProperty("나이", 23);
		jsonObj1.addProperty("직업", "CEO");
		jsonObj1.addProperty("취미", "노래");
		jsonObj1.addProperty("결혼여부", false);

		// JSONObject 에서 값 꺼내 보기
		System.out.println(jsonObj1.get("이름"));
		System.out.println(jsonObj1.get("나이"));
		System.out.println(jsonObj1.get("직업"));
		System.out.println(jsonObj1.get("취미"));
		System.out.println(jsonObj1.get("결혼여부"));
		System.out.println(jsonObj1);
		
		// 깊은 복사와 얕은 복사 개념 이해 하기 
		JsonObject jsonObj2 = jsonObj1; // 얕은 복사 
		JsonObject jsonObj3 = jsonObj1.deepCopy(); // 깊은 복사 
		
		System.out.println("-------------");
		jsonObj2.addProperty("이름", "변경됨??");
		System.out.println(jsonObj1);
		System.out.println("---------------------");
		jsonObj3.addProperty("이름", "이순신");
		System.out.println(jsonObj3);
		System.out.println("---------------------");
		System.out.println(jsonObj1);
		
		JsonArray jsonArray = new JsonArray(); 
		jsonArray.add(jsonObj1);
		jsonArray.add(jsonObj2);
		jsonArray.add(jsonObj3);
		
		System.out.println(jsonArray);
		
//		JSONArray jsonObjectArray = new JSONArray();
//		JsonArray jsonArray = new JsonArray();
//		jsonArray.add(jsonObj);
		
//		jsonObjectArray.put(jsonObj);
//		jsonObjectArray.put(jsonObj);
//		jsonObjectArray.put(jsonObj);

//        Log.d("TAG", jsonObjectArray.toString());

		// jsonObjectArray 에서 값 꺼내기
//		try {
//			JSONObject arrJson0 = jsonObjectArray.getJSONObject(0);
//			Log.d("TAG", "이름 : " + arrJson0.get("이름"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//
//		// { arr : [ {} , {}]}
//		JSONObject jsonObj2 = new JSONObject();
//		try {
//			jsonObj2.put("arr", jsonObjectArray);
//		} catch (JSONException e1) {
//			e1.printStackTrace();
//		}
//		Log.d("TAG", jsonObj2.toString());
//
//		// json parsing
//		JSONObject obj;
//		try {
//			obj = new JSONObject(jsonObj2.toString());
//
//			JSONArray array = obj.getJSONArray("arr");
//			JSONObject dataObj = array.getJSONObject(0);
//
//			String friendName = dataObj.getString("이름");
//			String friendAge = dataObj.getString("나이");
//
//			Log.d("TAG", "friendName:" + friendName);
//			Log.d("TAG", "friendAge:" + friendAge);
//
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}

	}

}
