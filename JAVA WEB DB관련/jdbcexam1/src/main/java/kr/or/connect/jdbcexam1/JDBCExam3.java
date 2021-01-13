package kr.or.connect.jdbcexam1;

import java.util.List;

import kr.or.connect.jdbcexam1.dao.RoleDaoSELECTALL;
import kr.or.connect.jdbcexam1.dto.Role;

public class JDBCExam3 {
	public static void main(String[] args) {

		RoleDaoSELECTALL dao = new RoleDaoSELECTALL();
		
		List<Role> list = dao.getRoles();

		for(Role role : list) {
			System.out.println(role);
		}
	} 
}