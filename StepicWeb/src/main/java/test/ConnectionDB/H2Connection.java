package test.ConnectionDB;

import org.h2.jdbcx.JdbcDataSource;
import test.ConnectionDB.GetConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection implements GetConnection {

    @Override
    public Connection getConnection() {
        try{
            String url = "jdbc:h2:tcp://localhost/~/test";
            String name = "sa";
            String pass = "";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            return DriverManager.getConnection(url, name, pass);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
