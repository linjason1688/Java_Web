/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Electrical_Plumbing_Engineering;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jason
 */
public class CSVservlet extends HttpServlet {
String htmlStr="";
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
        String frontFileName = request.getParameter("fileName");
        
        ServletContext context = request.getServletContext();
        
        CSV_browse csv_browse = null;
        
        
        switch(request.getParameter("actionID")) {
            case "showFields":
                csv_browse = new CSV_browse(context.getRealPath("/"), frontFileName);
                csv_browse.setReadBuffer();
                htmlStr = csv_browse.showFields();
                csv_browse.close();
                htmlStandardView(request, response);
            case "browse":
                csv_browse = new CSV_browse(context.getRealPath("/"), frontFileName);
                csv_browse.setReadBuffer();
                htmlStr = csv_browse.htmlForBrowse();
                csv_browse.close();
                htmlStandardView(request, response);
            case "getShoppingCar":
                csv_browse = new CSV_browse(context.getRealPath("/"), frontFileName);
                csv_browse.setReadBuffer();
                htmlStr = csv_browse.getFieldOfShoppingCar();
                csv_browse.close();
                htmlStandardView(request, response);
//            case "getMenu":
//                csv_browse = new CSV_browse(context.getRealPath("/"), frontFileName);
//                csv_browse.setReadBuffer();
//                htmlStr = csv_browse.getMenu();
//                csv_browse.close();
//                htmlStandardView(request, response);
//            case "getProduct":
//                csv_browse = new CSV_browse(context.getRealPath("/"), frontFileName);
//                csv_browse.setReadBuffer();
//                htmlStr = "";
//                htmlStr = csv_browse.getProduct();
//                csv_browse.close();
//                htmlStandardView(request, response);
//            case "getProductType":
//                csv_browse = new CSV_browse(context.getRealPath("/"), frontFileName);
//                csv_browse.setReadBuffer();
//                htmlStr = "";
//                htmlStr = csv_browse.getProductType();
//                csv_browse.close();
//                htmlStandardView(request, response);
            default:
                break;
        }
    }
    
    public void htmlStandardView(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet javaServle</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(htmlStr);
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
        processRequest(request, response);
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
