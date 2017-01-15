package sec.project.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Account extends AbstractPersistable<Long> {

    @Column(unique = true)
    private String username;
    private String password;
    private boolean admin;

    public Account() {
        super();
    }

    public Account(String username, String password, boolean admin) {
        this();
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
