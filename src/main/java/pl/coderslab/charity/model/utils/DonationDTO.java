package pl.coderslab.charity.model.utils;

import lombok.Data;
import pl.coderslab.charity.model.entities.Category;
import pl.coderslab.charity.model.entities.Institution;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DonationDTO {

    @Id
    private Long id;
    @Positive
    private Integer quantity;
    private List<Category> categories = new ArrayList<>();
    private Institution institution;
    private String street;
    private String City;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
}
