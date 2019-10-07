package pl.coderslab.charity.model.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Getter @Setter
public class InstitutionDTO {

    @Id
    private Long id;
    @NotBlank
    private String name;
    private String description;

    public InstitutionDTO() {
    }
}
