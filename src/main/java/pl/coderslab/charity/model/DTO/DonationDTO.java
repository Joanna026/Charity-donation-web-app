package pl.coderslab.charity.model.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.model.entities.Category;

import javax.persistence.Id;
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
    private List<CategoryDTO> categories = new ArrayList<>();
    private InstitutionDTO institutionDTO;
    private String street;
    private String City;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public DonationDTO() {
    }
}
