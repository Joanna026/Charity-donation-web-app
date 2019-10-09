package pl.coderslab.charity.model.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "roles")
@Getter
public class Role extends BaseEntity {

    @Column(nullable = false)
    private String authority;

    public String getAuthority() {
        return authority;
    }
}
