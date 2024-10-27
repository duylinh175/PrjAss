/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.accesscontrol;

import dal.UserDBContext;
import entity.PermissionDirect;
import entity.accesscontrol.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Permission;
import java.util.List;

/**
 *
 * @author sonng
 */
public class LoginController extends HttpServlet {
/** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        UserDBContext db = new UserDBContext();
        User account = db.get(user, pass);
        
        if(account!=null)
        {
            req.getSession().setAttribute("account", account);
            User myPermission = db.getPermissionDirect(user);
            String PATH = myPermission.getPermisson().get(0).getUrl();
            req.getRequestDispatcher(PATH).forward(req, resp);
            resp.getWriter().println("login successful!");
        }
        else
        {
            resp.getWriter().println("login failed!");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //pre-processing
        req.getRequestDispatcher("login.html").forward(req, resp);
        //post-processing
    }
    public static void main(String[] args) {
        UserDBContext db = new UserDBContext();
  
           System.out.println(db.getPermissionDirect("admin1").getPermisson());
    }
}
