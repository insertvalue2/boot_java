package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClient {

	private static final String DB_HOST = "localhost"; // host 주소
	private static final int DB_PORT = 3306;
	private static final String DB_DATABASE_NAME = "shopdb"; // 데이터베이스이름
	private static final String DB_CHARSET = "UTF-8"; // character set
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";

	// 멤버 변수
	private Connection conn = null;

	// 싱글톤 처리
	private static DBClient dbClient;

	private DBClient() {
	}

	public static DBClient getInstance() {
		if (dbClient == null) {
			dbClient = new DBClient();
		}
		return dbClient;
	}

	private static void unBindingDBClient() {
		dbClient = null;
	}

	public Connection getConnection() {
		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);
			try {
				// MySQL JDBC의 드라이버 클래스를 로딩해서 DriverManager클래스에 등록한다.
				Class.forName("com.mysql.cj.jdbc.Driver");
				// DriverManager 객체를 사용하여 DB에 접속
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>> Connection Success <<<");
			} catch (ClassNotFoundException e) {
				System.out.println(">>> Connection Fail <<<");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println(">>> Connection Fail <<<");
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void connectionClose() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println(">>> Connection Close Ok");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
