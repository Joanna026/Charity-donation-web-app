package pl.coderslab.charity.model.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DonationDTO {

    @Positive
    private Integer quantity;
    private List<CategoryDTO> categories = new ArrayList<>();
    private InstitutionDTO institutionDTO;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public DonationDTO() {
    }
}
