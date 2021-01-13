package kr.or.connect.jdbcexam1;

import kr.or.connect.jdbcexam1.dao.RoleDaoDELETE;

public class JDBCExam4 {
	public static void main(String[] args) {
//삭제 테스트
		int roleId = 500;

		RoleDaoDELETE dao = new RoleDaoDELETE();
		int deleteCount = dao.deleteRole(roleId);

		System.out.println(deleteCount);
	}
}