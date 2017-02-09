package kth.se.id2208.hw3.server.model.data.records;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kim Hammar on 2017-02-09.
 */
@XmlRootElement
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest(){

    }

    public String getUsername() {
        return username;
    }

    @XmlElement(name="username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement(name="password")
    public void setPassword(String password) {
        this.password = password;
    }
}
