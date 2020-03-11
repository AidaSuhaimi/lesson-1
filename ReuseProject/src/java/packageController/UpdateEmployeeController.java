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
public class UpdateEmployeeController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateEmployeeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateEmployeeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
        Employee emp = new Employee();
        
        emp.setEmp_id(request.getParameter("empID"));
        emp.setEmp_name(request.getParameter("empName"));
        emp.setEmp_ic(request.getParameter("empIC"));
        emp.setEmp_address(request.getParameter("address"));
        emp.setEmp_email(request.getParameter("email"));
        emp.setEmp_contact(request.getParameter("phoneNum"));
        emp.setEmp_gender(request.getParameter("gender"));
        emp.setEmp_dob(Date.valueOf(request.getParameter("dob")));
        emp.setEmp_department(Integer.parseInt(request.getParameter("department")));
        emp.setEmp_position(Integer.parseInt(request.getParameter("position")));
        //emp.setEmp_salary(Integer.parseInt(request.getParameter("salary")));
        
        emp.updateEmployee(request.getParameter("empID"));
        response.sendRedirect("ViewEmployee");
 
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
