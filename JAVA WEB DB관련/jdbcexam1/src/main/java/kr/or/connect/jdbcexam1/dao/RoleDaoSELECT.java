package kr.or.connect.jdbcexam1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.jdbcexam1.dto.Role;

public class RoleDaoSELECT {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?&useSSL=false";
	private static String dbUser = "root";
	private static String dbpasswd = "qsd1001918";

	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		//결과값 가져오니까 resultset필요 insert 이런거에는 필요없음
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver"); // driver 메모리에 로드
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);  
			ps.setInt(1, roleId); // ? 바운딩
			rs = ps.executeQuery(); //실행

			if (rs.next()) {
				String description = rs.getString(1); //결과값 get하기 sql 실행시 컬럼 순서
				int id = rs.getInt("role_id"); //컬럼 이름으로도 가능
				role = new Role(id, description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//close반대로
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return role;
	}
}