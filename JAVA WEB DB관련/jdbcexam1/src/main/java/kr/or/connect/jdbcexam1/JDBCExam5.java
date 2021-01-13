package kr.or.connect.jdbcexam1;

import kr.or.connect.jdbcexam1.dao.RoleDaoUPDATE;
import kr.or.connect.jdbcexam1.dto.Role;

public class JDBCExam5 {
	public static void main(String[] args) {
//수정테스트
		int roleId = 500;
		String description = "CEO";
		
		Role role = new Role(roleId, description);
		
		RoleDaoUPDATE dao = new RoleDaoUPDATE();
		int updateCount = dao.updateRole(role);

		System.out.println(updateCount);
	} 
}