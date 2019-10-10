package pl.coderslab.charity.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter @Setter
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;
    private String firstname;
    private String lastname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private Boolean enabled;
    @OneToOne
    private Role authority;

    public User() {
        super();
        this.enabled = false;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
