package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardManagerDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/cardmanagerdb?&useSSL=false&serverTimezone=UTC";
	private static String dbUser = "root";
	private static String dbpasswd = "qsd1001918";
	
    public List<BusinessCard> searchBusinessCard(String keyword){
    	
    	List<BusinessCard> bcList = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT name, phone, companyName, createDate FROM cardmanagerinfo WHERE name like ?;";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%"+keyword+"%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String name = rs.getString(1);
					String phone = rs.getString(2);
					String companyName = rs.getString(3);
					BusinessCard businessCard = new BusinessCard(name, phone, companyName);
					bcList.add(businessCard); 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bcList;
    }

    public BusinessCard addBusinessCard(BusinessCard businessCard){
    	
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}

    		String sql = "INSERT INTO cardmanagerinfo(name, phone, companyName, createDate) VALUES (?, ?, ?, ?);";
    		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
    				PreparedStatement ps = conn.prepareStatement(sql)) {
    				ps.setString(1, businessCard.getName());
    				ps.setString(2, businessCard.getPhone());
    				ps.setString(3, businessCard.getCompanyName());
    				ps.setString(4, new Date(businessCard.getCreateDate().getTime()).toString());
    				int insertCount = ps.executeUpdate();
    		}catch (Exception e) {
        		e.printStackTrace();
			}
    		return businessCard;
    }
}
