package ch04;

// 사용 안함 XXX 
public interface IEmployeesDao {
	
	// inner join : userTbl, buyTbl 결과 *
	void innerJoin1();
	
	// left join : userTbl, buyTbl 결과 * 
	void leftJoin1(); 
	
	// left join : userTbl, buyTbl null 제거 결과 *
	void leftJoin2();
	
	// left join : buyTbl, userTbl 결과 *
	void leftJoin3();
	
	// left join : buyTbl, userTbl 결과 *
	void leftJoin4();
}
