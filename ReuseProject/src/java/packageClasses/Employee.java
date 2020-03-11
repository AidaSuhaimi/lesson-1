package packageClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class Employee {
    private String emp_id , emp_name , emp_contact , emp_email , emp_ic, emp_address, emp_gender ;
    private Date emp_dob;
    private int emp_position , emp_department , emp_salary;

    public Employee() {
    }
    
    public Employee(String empID){
        this.emp_id = empID;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_contact() {
        return emp_contact;
    }

    public void setEmp_contact(String emp_contact) {
        this.emp_contact = emp_contact;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_ic() {
        return emp_ic;
    }

    public void setEmp_ic(String emp_ic) {
        this.emp_ic = emp_ic;
    }

    public Date getEmp_dob() {
        return emp_dob;
    }

    public void setEmp_dob(Date emp_dob) {
        this.emp_dob = emp_dob;
    }

    public int getEmp_position() {
        return emp_position;
    }

    public void setEmp_position(int emp_position) {
        this.emp_position = emp_position;
    }

    public int getEmp_department() {
        return emp_department;
    }

    public void setEmp_department(int emp_department) {
        this.emp_department = emp_department;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
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
    public void addEmployee() {
        String sql = "INSERT INTO employee(emp_id,emp_name,emp_phonenumber,emp_email,emp_ic,emp_dob,emp_positionid,emp_departmentid,emp_gender,emp_address) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Employee emp = new Employee();
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,this.emp_id);
            pstmt.setString(2,this.emp_name);
            pstmt.setString(3,this.emp_contact);
            pstmt.setString(4,this.emp_email);
            pstmt.setString(5, this.emp_ic);
            pstmt.setDate(6, (java.sql.Date) this.emp_dob);
            pstmt.setInt(7, this.emp_position);
            pstmt.setInt(8, this.emp_department);
            pstmt.setString(9, this.emp_gender);
            pstmt.setString(10, this.emp_address);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

        public void deleteEmployee(String empID) {
        String sql = "DELETE FROM EMPLOYEE WHERE emp_id = '" + empID + "'";
        
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
        
        public void updateEmployee(String empID) {
            String sql = "UPDATE EMPLOYEE "
                    + "SET emp_id ='" + this.emp_id + "', emp_name='" + this.emp_name + "' , emp_phonenumber='" + this.emp_contact + "',emp_email='" + this.emp_email + "'"
                    + ",emp_ic='" + this.emp_ic + "' , emp_dob='" + this.emp_dob + "' , emp_positionid=" + this.emp_position + " , emp_departmentid=" + this.emp_department + ""
                    + ", emp_gender='" + this.emp_gender + "' ,emp_address='" + this.emp_address + "'"
                    + "WHERE emp_id ='" + empID + "'";
            
        Employee emp = new Employee();
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    
}