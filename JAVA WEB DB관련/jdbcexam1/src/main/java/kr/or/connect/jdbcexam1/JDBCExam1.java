package kr.or.connect.jdbcexam1;

import kr.or.connect.jdbcexam1.dao.RoleDaoSELECT;
import kr.or.connect.jdbcexam1.dto.Role;

public class JDBCExam1 {

	public static void main(String[] args) {
		RoleDaoSELECT dao = new RoleDaoSELECT();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}