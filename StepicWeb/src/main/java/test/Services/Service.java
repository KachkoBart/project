package test.Services;

import java.sql.Connection;
import java.sql.SQLException;

import static test.Main.h2connection;


public interface Service {
    Connection connection = h2connection;
    int add(String[] strings) throws SQLException;
    void remove(String login) throws SQLException;
    void refactor(String login, String password) throws SQLException;
}
