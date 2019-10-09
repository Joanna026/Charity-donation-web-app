package pl.coderslab.charity.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter @Setter
public class Donation extends BaseEntity{


    @Column (nullable = false)
    private Integer quantity;
    @ManyToMany
    private List<Category> categories = new ArrayList<>();
    @ManyToOne
    private Institution institution;
    private String street;
    private String City;
    private String zipCode;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;


    @Override
    public String toString() {
        return "Donation{" +
                super.toString() +
                ", quantity=" + quantity +
                ", institution=" + institution +
                ", street='" + street + '\'' +
                ", City='" + City + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", pickUpTime=" + pickUpTime +
                ", pickUpComment='" + pickUpComment + '\'' +
                '}';
    }
}
