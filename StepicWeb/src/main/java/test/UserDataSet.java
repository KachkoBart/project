package test;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class UserDataSet {
    private long id;
    private String login;
    private int password;
    UserDataSet(String login, int password, long id){
        this.login = login;
        this.password = password;
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public int getPassword() {
        return password;
    }
    public String getLogin() {
        return login;
    }
}
