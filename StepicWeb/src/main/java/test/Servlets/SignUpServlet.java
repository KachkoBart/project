package test.Servlets;

import test.GetContext.Content;
import test.GetContext.ContentImpl;
import test.Services.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {
    public Service service;
    public SignUpServlet(Service service){
        this.service = service;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String[] strings = new String[]{req.getParameter("mail"), req.getParameter("name"), req.getParameter("surname"), req.getParameter("password")};
            if(service.add(strings) == 0){
                doGet(req,resp);
            }
            Content content = new ContentImpl();
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(content.getPage("signin.html"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Content content = new ContentImpl();
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(content.getPage("signup.html"));
    }
}
