package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest1 {
	
	private Connection conn; // DB 커넥션 연결 객체 
	private static final String USERNAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8"; // 접속할 DB 명
	
	Statement stmt = null;
	ResultSet rs = null;	
	
	public MainTest1() {
		
		// The server time zone value 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();

			
			String sql1 = "select * from membertbl";
			rs = stmt.executeQuery(sql1);
			while(rs.next()) {
				String memberId = rs.getString("memberId");
				String memberName = rs.getString("memberName");
				System.out.println("no = "+memberId+" , "+"name = "+memberName);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new MainTest1(); 
	}
}
