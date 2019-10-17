package pl.coderslab.charity.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="institutions")
@Getter @Setter
public class Institution extends BaseEntity {


    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    private Boolean archived;


    @Override
    public String toString() {
        return "Institution{" +
                super.toString() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
