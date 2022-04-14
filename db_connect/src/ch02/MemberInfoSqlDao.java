package ch02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * 
 * @author ITPS
 * 
 */
public class MemberInfoSqlDao implements IMemberInfoDao {

	/** DBHelper를 통한 DB 접속 처리 */
	private static final String TABLE_NAME = "memberTBL";
	private DBClient dbClient;
	private Connection conn;
	
	public MemberInfoSqlDao() {
		dbClient = DBClient.getInstance();
		conn = dbClient.getConnection();
	}
	
	@Override
	public ArrayList<MemberDto> select(String memberId) {
		ArrayList<MemberDto> dataResult = new ArrayList<>();
		String sqlFormat;
		String sql;
		
		if (memberId == "" || memberId == null) {
			sqlFormat = "SELECT * FROM %s";
			sql = String.format(sqlFormat, TABLE_NAME);
		} else {
			sqlFormat = "SELECT * FROM %s WHERE memberId ='%s'";
			sql = String.format(sqlFormat, TABLE_NAME, memberId);
		}

		/* SQL 구문 실행하기 */
		
		// SQL문을 실행할 수 있는 객체
		Statement stmt = null;
		// 쿼리문에 결과를 받을 수 있는 객체
		ResultSet rs = null;
		
		// 초기화
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			 
			while(rs.next()) {
				// dto 셋팅 
				MemberDto dto = new MemberDto();
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberAddress(rs.getString("memberAddress"));
				
				// 자료구조에 dto 담기 
				dataResult.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return dataResult;
	}

	@Override
	public void insert(MemberDto dto) {
		String sqlFormat = "insert into %s values('%s', '%s', '%s')";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberId(), dto.getMemberName(),
				dto.getMemberAddress());
		
		Statement stmt = null; 
		int result = 0;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println("result : 행 갯수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int update(MemberDto dto) {
		
		// 해당 레코드 존재 여부 검사 select 
		String sqlFormat = "UPDATE %s SET memberName = '%s' WHERE memberId = '%s' ";
		String sql = String.format(sqlFormat,TABLE_NAME, dto.getMemberName(), dto.getMemberId());
		int result = 0;
		
		try(Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}

	@Override
	public void delete(String memberId) {
		// 해당 레코드 존재 여부 검사 select 
		String sqlFormat = "DELETE FROM %s WHERE memberId = '%s'";
		String sql = String.format(sqlFormat,TABLE_NAME, memberId);
		
		Statement stmt = null; 
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println("result :  " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
