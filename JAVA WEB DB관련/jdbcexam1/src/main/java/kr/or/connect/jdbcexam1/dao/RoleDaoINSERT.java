package kr.or.connect.jdbcexam1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam1.dto.Role;

public class RoleDaoINSERT {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?&useSSL=false";
	private static String dbUser = "root";
	private static String dbpasswd = "qsd1001918";

	public int addRole(Role role) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, role.getRoleId()); //INSERT 쿼리에 있는 컬럼 순서
			ps.setString(2, role.getDescription());

			insertCount = ps.executeUpdate(); //insert, update, delete 는 executeUpdate이런식으로 사용
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
}