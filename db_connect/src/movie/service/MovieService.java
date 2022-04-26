package movie.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ch05.DBClient2;
import movie.dto.RequestMovie;
import movie.dto.ResPonseMovie;

public class MovieService implements IMovieService {

	private DBClient2 client2;
	private Connection conn;
	private PreparedStatement pstmp;
	private ResultSet rs;

	private String selectQuery = "SELECT a.이름 as 영화이름, a.개봉연도, " + "a.매출액, a.관객수, a.평점, b.역, c.이름 as 배우이름 "
			+ "FROM 영화 as a " + "INNER JOIN 출연 as b " + "ON a.번호 = b.영화번호 " + "INNER JOIN 배우 as c "
			+ "ON b.배우번호 = c.번호 ";

	public MovieService() {
		client2 = DBClient2.getInstance();
		conn = client2.getConnection();
	}

	@Override
	public List<ResPonseMovie> selectAllMovieInfo() {
		List<ResPonseMovie> list = new ArrayList<ResPonseMovie>();
		try {
			pstmp = conn.prepareStatement(selectQuery);
			rs = pstmp.executeQuery();
			while (rs.next()) {
				ResPonseMovie movie = new ResPonseMovie();
				movie.setMovieName(rs.getString("영화이름"));
				movie.setYear(rs.getString("개봉연도"));
				movie.setSales(rs.getString("매출액"));
				movie.setAudience(rs.getString("관객수"));
				movie.setRating(rs.getString("평점"));
				movie.setRoleName(rs.getString("역"));
				movie.setName(rs.getString("배우이름"));
				list.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ResPonseMovie> selectMovieByMovieName(String movieName) {
		String query = selectQuery + " WHERE a.이름 LIKE ? ";
		List<ResPonseMovie> list = new ArrayList<ResPonseMovie>();
		try {
			pstmp = conn.prepareStatement(query);
			pstmp.setString(1, "%" + movieName.trim() + "%");
			rs = pstmp.executeQuery();
			while (rs.next()) {
				ResPonseMovie movie = new ResPonseMovie();
				movie.setMovieName(rs.getString("영화이름"));
				movie.setYear(rs.getString("개봉연도"));
				movie.setSales(rs.getString("매출액"));
				movie.setAudience(rs.getString("관객수"));
				movie.setRating(rs.getString("평점"));
				movie.setRoleName(rs.getString("역"));
				movie.setName(rs.getString("배우이름"));
				list.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insertMovie(RequestMovie req) {
		boolean flag = true;
		// 트랜 잭션 사용하기
		try {
			conn.setAutoCommit(false); // 기본값이 true
			// 1
			// 영화 테이블에 마지막 번호 들고 오기
			String query1 = "SELECT 번호 FROM 영화 ORDER BY 번호 DESC LIMIT 1 ";
			rs = conn.prepareStatement(query1).executeQuery();
			while (rs.next()) {
				int tempId = Integer.parseInt(rs.getString("번호")) + 1;
				req.set영화번호(tempId);
				System.out.println("영화번호" + req.get영화번호());
			}
			// 배우 테이블에 마지막 번호 들고 오기
			String query2 = "SELECT 번호 FROM 배우 ORDER BY 번호 DESC LIMIT 1 ";
			rs = conn.prepareStatement(query2).executeQuery();
			while (rs.next()) {
				int tempId = Integer.parseInt(rs.getString("번호")) + 1;
				req.set배우번호(tempId);
				System.out.println("배우번호" + req.get배우번호());
			}
			// 2
			String query3 = "INSERT INTO 영화(번호, 이름, 개봉연도, 관객수, 평점) " + " VALUES(?,?,?,?,?)";
			pstmp = conn.prepareStatement(query3);
			pstmp.setInt(1, req.get영화번호());
			pstmp.setString(2, req.get영화이름());
			pstmp.setInt(3, req.get개봉연도());
			pstmp.setInt(4, req.get관객수());
			pstmp.setDouble(5, req.get평점());
			// 3
			pstmp.executeUpdate();

			String query4 = "INSERT INTO 배우(번호, 이름, 출생, 키, 몸무게) " + " VALUES(?,?,?,?,?)";
			pstmp = conn.prepareStatement(query4);
			pstmp.setInt(1, req.get배우번호());
			pstmp.setString(2, req.get배우이름());
			pstmp.setTimestamp(3, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			pstmp.setInt(4, req.get키());
			pstmp.setInt(5, req.get몸무게());
			pstmp.executeUpdate();

			String query5 = "INSERT INTO 출연(영화번호, 배우번호, 역할, 역) VALUES(?,?,?,?)";
			pstmp = conn.prepareStatement(query5);
			pstmp.setInt(1, req.get영화번호());
			pstmp.setInt(2, req.get배우번호());
			pstmp.setInt(3, req.get역할());
			pstmp.setString(4, req.get역());
			pstmp.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public void updateMovie(String oldName, String newName) {
		String query = "UPDATE 영화 SET 이름 = ? WHERE 이름 = ? ";
		try {
			pstmp = conn.prepareStatement(query);
			pstmp.setString(1, newName);
			pstmp.setString(2, oldName);
			pstmp.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMovie(int movieId) {
		try {
			conn.setAutoCommit(false);
			// 해당
			String query1 = "DELETE FROM 출연 WHERE 영화번호 = ? ";
			pstmp = conn.prepareStatement(query1);
			pstmp.setInt(1, movieId);
			pstmp.executeUpdate();
			
			String query2 = "DELETE FROM 영화 WHERE 번호 = ?";
			pstmp = conn.prepareStatement(query2);
			pstmp.setInt(1, movieId);
			pstmp.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close() {
		client2.connectionClose();
	}

}
