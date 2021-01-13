package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/guestbookdb?&useSSL=false&serverTimezone=UTC";
	private static String dbUser = "root";
	private static String dbpasswd = "qsd1001918";
	
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT id, name, content, regdate FROM guestbook;";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Long id = Long.parseLong(rs.getString(1));
					String name = rs.getString(2);
					String content = rs.getString(3);
					Date regdate = rs.getDate(4);
					Guestbook guestbook = new Guestbook(id, name, content, regdate);
					list.add(guestbook); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

        return list;
    }

    public void addGuestbook(Guestbook guestbook){
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO guestbook(name, content, regdate) VALUES (?, ?, ?);";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, guestbook.getName());
				ps.setString(2, guestbook.getContent());
				//ps.setString(3, guestbook.getRegdate());
				java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentTime = simpleDateFormat.format(guestbook.getRegdate().getTime());
				ps.setString(3,  currentTime);
				//ps.setString(3, new Date(guestbook.getRegdate().getTime()).toString());
				int insertCount = ps.executeUpdate();
		}catch (Exception e) {
    		e.printStackTrace();
		}
    }
}
