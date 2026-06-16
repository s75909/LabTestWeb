/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drivesmart.dao;

import java.sql.*;
import java.util.*;
import com.drivesmart.bean.SessionBean;
/**
 *
 * @author MP2-4
 */
public class SessionDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/drivesmart_db";
    private String jdbcUsername ="root";
    private String jdbcPassword="";
    
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public void bookSession(SessionBean session){
        String sql= "INSERT INTO Training_Sessions(student_name, branch_location, lesson_type, status) VALUES (?,?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, session.getStudent_name());
            ps.setString(2, session.getBranch_location());
            ps.setString(3, session.getLesson_type());
            ps.setString(4, session.getStatus());
            ps.executeUpdate();
            
            
        } catch (SQLException e){
         e.printStackTrace();
    }
   }
    
    public List<SessionBean> getAllSessions() {
        List<SessionBean> list = new ArrayList<>();
        String sql = "SELECT * FROM Training_Sessions ORDER BY branch_location ASC";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                SessionBean s = new SessionBean(
                    rs.getInt("session_id"),
                    rs.getString("student_name"),
                    rs.getString("branch_location"),
                    rs.getString("lesson_type"),
                    rs.getString("status")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
