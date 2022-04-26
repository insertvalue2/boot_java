package ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbJoinTest2 {

	public static void main(String[] args) {
		
		DBClient2 client = DBClient2.getInstance(); 
		Connection connection = client.getConnection(); 
		ResultSet resultSet = null;
		List<MovieDto> list = new ArrayList<MovieDto>();
		
		String query = "select a.이름 as 영화이름, a.개봉연도,"
				+ " a.매출액, a.관객수, a.평점, b.역, "
				+ " c.이름 as 배우이름 "
				+ "from 영화 as a "
				+ "inner join 출연 as b "
				+ "on a.번호 = b.영화번호 "
				+ "inner join 배우 as c "
				+ "on b.배우번호 = c.번호 "
				+ "where a.이름 LIKE ? ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, "%명량%");
			
			resultSet = stmt.executeQuery(); 
			while(resultSet.next()) {
				MovieDto dto = new MovieDto();
				dto.setMovieName(resultSet.getString("영화이름"));
				dto.setYear(resultSet.getString("개봉연도"));
				dto.setSales(resultSet.getString("매출액"));
				dto.setAudience(resultSet.getString("관객수"));
				dto.setRating(resultSet.getString("평점"));
				dto.setRoleName(resultSet.getString("역"));
				dto.setName(resultSet.getString("배우이름"));
				
				list.add(dto);
			}
			System.out.println(list.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.connectionClose();

	}

}
