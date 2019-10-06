package pl.coderslab.charity.model.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categories")
@Getter @Setter
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    public Category() {
        super();
    }

    @Override
    public String toString() {
        return "Category{" +
                super.toString() +
                "name='" + name + '\'' +
                '}';
    }
}
