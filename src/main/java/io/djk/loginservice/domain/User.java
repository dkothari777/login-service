package io.djk.loginservice.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * Created by dkothari on 2/22/19.
 */

@Entity
@Table( name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
