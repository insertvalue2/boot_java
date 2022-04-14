package ch04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ch02.DBClient;

public class MainTest1 {

	public static void main(String[] args) {
		
		DBClient client = DBClient.getInstance(); 
		Connection connection = client.getConnection(); 
		
		ResultSet resultSet = null;
		try {
			
			/* 데이터 한건 조회 */
			//Statement stmt = connection.createStatement();
			String selectQuery1 = "SELECT * FROM memberTBL WHERE memberId = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			preparedStatement.setString(1, "questzz");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			} 
			
			System.out.println("-----------------------------------------------");
			/* 데이터 조회 */
			String selectQuery2 = "SELECT * FROM memberTBL WHERE memberId IN(?, ?)";
			preparedStatement = connection.prepareStatement(selectQuery2);
			preparedStatement.setString(1, "questzz");
			preparedStatement.setString(2, "Han");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
				System.out.println(">>>>>>>");
			}
			
			System.out.println("-----------------------------------------------");
			
			/* insert 데이터 등록 */
			String insertQuery = "INSERT INTO memberTBL VALUES(?, ?, ?)";
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, "boot1");
			preparedStatement.setString(2, "개발자");
			preparedStatement.setString(3, "서울 판교");
			
			int resultCount = 0;
			try {
				resultCount = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(resultCount >= 1) {
				System.out.println("정상 등록 되었습니다.");
			} else {
				System.out.println("동일한 아이디가 존재 하거나 잘못된 입력입니다.");
			}
			
			preparedStatement = connection.prepareStatement("SELECT * FROM memberTBL");
			resultSet = preparedStatement.executeQuery();
			System.out.println("데이터 등록 후 출력 ");
			while(resultSet.next()) {
				System.out.print(resultSet.getString("memberId") + " ");
				System.out.print(resultSet.getString("memberName") + " ");
				System.out.print(resultSet.getString("memberAddress") + " ");
				System.out.println();
			}
			
			System.out.println("-----------------------------------------------");
			
			/* update : 데이터 수정 */
			String updateQuery = "UPDATE memberTBL SET memberName = ? WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, "이름변경1");
			preparedStatement.setString(2, "questzz");
			int updateCount = preparedStatement.executeUpdate();
			System.out.println("updateCount : " + updateCount);
			
			System.out.println("-----------------------------------------------");
			
			/* delete : 데이터 삭제 */
			String delteQuery = "DELETE FROM memberTBL WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(delteQuery);
			preparedStatement.setString(1, "boot1");
			int deleteCount = preparedStatement.executeUpdate();
			System.out.println("delteCount : " + deleteCount);
			
			System.out.println("-----------------------------------------------");
			preparedStatement = connection.prepareStatement("SELECT * FROM memberTBL");
			resultSet = preparedStatement.executeQuery();
			System.out.println("데이터 삭제 후 출력 ");
			while(resultSet.next()) {
				System.out.print(resultSet.getString("memberId") + " ");
				System.out.print(resultSet.getString("memberName") + " ");
				System.out.print(resultSet.getString("memberAddress") + " ");
				System.out.println();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
