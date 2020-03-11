package packageClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class Department {
    private int DepartID;
    private String DepartName;

    public int getDepartID() {
        return DepartID;
    }

    public void setDepartID(int DepartID) {
        this.DepartID = DepartID;
    }

    public String getDepartName() {
        return DepartName;
    }

    public void setDepartName(String DepartName) {
        this.DepartName = DepartName;
    }
    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:derby://localhost:1527/Administrator";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
        }
 
    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void addDepartment() {
        String sql = "INSERT INTO DEPARTMENT VALUES(?,?)";
        Department dept = new Department();
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,this.DepartID);
            pstmt.setString(2,this.DepartName);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteDepartment(int depID) {
        String sql = "DELETE FROM DEPARTMENT WHERE DEP_ID = " + depID + "";
        
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
        
        public void updateDepartment(int depID) {
            String sql = "UPDATE DEPARTMENT SET DEP_NAME ='" + this.DepartName + "' WHERE DEP_ID = " + depID + "";
                    
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    
}
