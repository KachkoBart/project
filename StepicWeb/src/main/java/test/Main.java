package test;

import java.sql.Connection;
import java.sql.DriverManager;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.mysql.jdbc.Driver;
import org.hibernate.cfg.Configuration;
import test.ConnectionDB.GetConnection;
import test.ConnectionDB.H2Connection;
import test.Services.AccountService;
import test.Services.Service;
import test.Servlets.SignInServlet;
import test.Servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        Service service = new AccountService();

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new SignInServlet(service)), "/signin");
        contextHandler.addServlet(new ServletHolder(new SignUpServlet(service)),"/signup");
        //contextHandler.addServlet(new ServletHolder(new WebSocketChatServlet(new ChatService())),"/chat");

        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("signin.html");
        resource_handler.setResourceBase("signup.html");
        resource_handler.setResourceBase("profile.html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, contextHandler});

        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.show.sql", "true");



        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        System.out.println("Server started");
        server.join();
    }
    private static GetConnection connection = new H2Connection();
    public static Connection h2connection = connection.getConnection();
}
