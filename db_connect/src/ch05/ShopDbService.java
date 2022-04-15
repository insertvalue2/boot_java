package ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ch02.DBClient;
import ch04.IEmployeesDao;

public class ShopDbService implements IEmployeesDao {

	/** DBHelper를 통한 DB 접속 처리 */
	private DBClient2 dbClient;
	private Connection conn;
	
	public ShopDbService() {
		dbClient = DBClient2.getInstance();
		conn = dbClient.getConnection();
	}
	
	@Override
	public void innerJoin1() {
		
		ArrayList<SalesHistory> list = new ArrayList<>();
		
		String sql = " SELECT * "
					+ "FROM  userTbl AS A "
					+ "INNER JOIN buyTbl AS B "
					+ "ON A.userName = B.userName";
		
		Statement stmt;
		
		try {
			
			
			stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			rs = pStmt.executeQuery();
			while(rs.next()) {
				SalesHistory salesHistory = new SalesHistory();
				salesHistory.setUserName(rs.getString("userName"));
				salesHistory.setAddr(rs.getString("addr"));
				salesHistory.setMobile(rs.getString("mobile"));
				salesHistory.setPrice(rs.getString("price"));
				salesHistory.setAmount(rs.getString("amount"));
				
				list.add(salesHistory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">>> 결과 출력 <<< ");
		System.out.println(list.toString());
		System.out.println("count : " + list.size());
	}

	@Override
	public void leftJoin1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftJoin2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftJoin3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftJoin4() {
		// TODO Auto-generated method stub
		
	}
	
}
