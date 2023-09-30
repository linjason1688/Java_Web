/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhonTung_05;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author USER
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
        String frontFileName     = request.getParameter("fileName");
               
        
        

        ServletContext context=request.getServletContext();
        
        CSV_browse a=null;
        QRcode d=null;
        XXXCSV_browse_showBanner b=null;

        
        switch(request.getParameter("actionID")){
            case "showFields":
                a=new CSV_browse(context.getRealPath("/"), frontFileName);
                a.setReadBuffer();
                htmlStr=a.showFields();
                a.close();
                htmlStandardView(request, response);
                break;
            case "browse":
                a=new CSV_browse(context.getRealPath("/"), frontFileName);
                a.setReadBuffer();
                htmlStr = a.htmlForBrowse();
                a.close();
                htmlStandardView(request, response);
                break;
                
            case "showBanner":
                b=new XXXCSV_browse_showBanner(context.getRealPath("/"), frontFileName);
                b.setReadBuffer();
                htmlStr=b.showBanner();
                b.close();
                htmlStandardView(request, response);
                break;
                
            case "getSlides":
                b=new XXXCSV_browse_showBanner(context.getRealPath("/"), frontFileName);
                b.setReadBuffer();
                htmlStr=b.getSlides();
                b.close();                
                //htmlStr="image/0.jpg,image/1.jpg,image/2.jpg,image/3.jpg,image/4.jpg";
                outputSlides(request, response);
                
                break;
                
            case "getShoppingCar":
                a=new CSV_browse(context.getRealPath("/"), frontFileName);
                a.setReadBuffer();
                htmlStr = a.getFieldsOfShoppingCar();

                a.close();                
                outputSlides(request, response);                
                break;
            case "getMenu"    :
                a=new CSV_browse(context.getRealPath("/"), frontFileName);
                a.setReadBuffer();                
                htmlStr=a.getMenu();
                a.close();
                outputSlides(request, response);                
                break;
            case "getProduct"    :
                a=new CSV_browse(context.getRealPath("/"), frontFileName);
                a.setReadBuffer();    
                htmlStr="";
                htmlStr=a.getProduct();
                a.close();
                outputSlides(request, response);                     
                break;
            case "getProductType"    :
                a=new CSV_browse(context.getRealPath("/"), frontFileName);
                a.setReadBuffer();                
                htmlStr="";
                htmlStr=a.getProductType();
                a.close();
                outputSlides(request, response);                     
                break;
            case "tableOrder":
                d=new QRcode();
                htmlStr=d.getHomePageWithTableNo(request.getParameter("TableNo"));
                outputSlides(request, response);   
                break;
            default:
                break;
                    
        }
        
        
        

      
    }
    
    public void  htmlStandardView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" href=\"home.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println(htmlStr);
            out.println("</body>");
            out.println("</html>");
        }        
    }  
    
    public void  outputSlides(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println(htmlStr);

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


