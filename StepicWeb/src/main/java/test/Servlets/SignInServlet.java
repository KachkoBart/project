package test.Servlets;

import test.GetContext.Content;
import test.GetContext.ContentImpl;
import test.Services.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class SignInServlet extends HttpServlet {
    private Service service;
    public SignInServlet(Service service){
        this.service = service;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            ResultSet row = service.connection.createStatement().executeQuery("SELECT * FROM USERS WHERE mail = '" + req.getParameter("mail") + "' AND password ='" + req.getParameter("password")+ "'");
            if(row.next()){
                resp.setStatus(200);
                resp.getWriter().println("Authorized: " + req.getParameter("mail"));
            }else{
                resp.setStatus(401);
                resp.getWriter().println("Unauthorized");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Content content = new ContentImpl();
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(content.getPage("signin.html"));

    }
}
