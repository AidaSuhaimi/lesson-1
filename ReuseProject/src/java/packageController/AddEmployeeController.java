/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import packageClasses.Employee;

/**
 *
 * @author User
 */
public class AddEmployeeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Employee obj = new Employee();
        
        try (PrintWriter out = response.getWriter()) {
            out.print(obj.getEmp_address());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
        try  {
        
        PrintWriter out = response.getWriter();
        Employee obj = new Employee();
        obj.setEmp_id(request.getParameter("empID"));
        obj.setEmp_name(request.getParameter("empName"));
        obj.setEmp_ic(request.getParameter("empIC"));
        obj.setEmp_address(request.getParameter("address"));
        obj.setEmp_email(request.getParameter("email"));
        obj.setEmp_contact(request.getParameter("phoneNum"));
        obj.setEmp_gender(request.getParameter("gender"));
        obj.setEmp_dob(Date.valueOf(request.getParameter("dob")));
        obj.setEmp_department(Integer.parseInt(request.getParameter("department")));
        obj.setEmp_position(Integer.parseInt(request.getParameter("position")));
        
        obj.addEmployee();
        response.sendRedirect("ViewEmployee");
        
        
        //response.sendRedirect("homeAdminPage.jsp");
        
        }
        
        catch (Exception e){
            e.getMessage();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    

}
