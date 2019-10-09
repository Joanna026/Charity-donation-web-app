package pl.coderslab.charity.model.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class DonationDTO {

    @Positive
    private Integer quantity;
    private InstitutionDTO institutionDTO;
    private CategoryDTO categoryDTO;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate pickUpDate;
    private String pickUpDateS;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public DonationDTO() {
    }

    public InstitutionDTO getInstitutionDTO() {
        return institutionDTO;
    }
}
