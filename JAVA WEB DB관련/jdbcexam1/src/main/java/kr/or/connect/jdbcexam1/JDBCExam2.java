package kr.or.connect.jdbcexam1;

import kr.or.connect.jdbcexam1.dao.RoleDaoINSERT;
import kr.or.connect.jdbcexam1.dto.Role;

public class JDBCExam2 {
	public static void main(String[] args) {
		int roleId = 501;
		String description = "CTO";
		
		Role role = new Role(roleId, description);
		
		RoleDaoINSERT dao = new RoleDaoINSERT();
		int insertCount = dao.addRole(role);

		System.out.println(insertCount);
	}
}