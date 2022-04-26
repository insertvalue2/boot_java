package ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbJoinTest1 {

	public static void main(String[] args) {
		
		DBClient2 client = DBClient2.getInstance(); 
		Connection connection = client.getConnection(); 
		
		ResultSet resultSet = null;
		List<AlbumDto> albumList = new ArrayList<>();
		 
		String query1 = "SELECT * FROM 곡";
		try {
			
			// 테스트 코드 1
			PreparedStatement pstmt = connection.prepareStatement(query1);
			resultSet = pstmt.executeQuery(); 
//			while(resultSet.next()) {
//				System.out.println(resultSet.getString("앨범번호"));
//				System.out.println(resultSet.getString("곡명"));
//			}
			
			// 테스트 코드 2
			String query2 = "SELECT a.앨범번호, a.아티스트, b.곡명 "
					+ "FROM 앨범 as a "
					+ "INNER JOIN 곡 as b "
					+ "ON a.앨범번호 = b.앨범번호 "
					+ "WHERE a.앨범번호 = 2";
			pstmt = connection.prepareStatement(query2);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				AlbumDto album = new AlbumDto(); 
				album.setAlbumId(Integer.parseInt(resultSet.getString("a.앨범번호")));
				album.setSongWriter(resultSet.getString("a.앨범번호"));
				album.setSongTitle(resultSet.getString("b.곡명"));
//				System.out.println(resultSet.getString("a.앨범번호"));
//				System.out.println(resultSet.getString("a.아티스트"));
//				System.out.println(resultSet.getString("b.곡명"));
				albumList.add(album);
			}
			// 2 - 1 dto 만들기 
			System.out.println(albumList.toString());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
