package test.Services;

import com.mysql.jdbc.PreparedStatement;
import test.Services.Service;

import java.sql.SQLException;
import java.sql.Statement;


public class AccountService implements Service {

    public AccountService() throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate("create table if not exists users (mail varchar(256), name varchar(256), surname varchar(256), password varchar(256))");
        stm.close();
    }
    public int add(String[] strings) throws SQLException {
        Statement stm = connection.createStatement();
        if(stm.executeQuery("SELECT mail FROM USERS WHERE mail = '" + strings[0] + "'").next()){
            return 0;
        }
        stm.executeUpdate("INSERT INTO USERS VALUES('" + strings[0]+ "','" + strings[1] + "','" + strings[2] + "','" + strings[3] + "')");
        stm.close();
        return 1;
    }

    @Override
    public void remove(String mail) throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate("DELETE FROM USERS VALUES('" + mail + "')");
        stm.close();
    }

    @Override
    public void refactor(String mail, String password) throws SQLException {
        Statement stm = connection.createStatement();
        stm.executeUpdate("UPDATE USERS SET password = '" + password + "', WHERE login = '" + mail + "'");
        stm.close();
    }

}
