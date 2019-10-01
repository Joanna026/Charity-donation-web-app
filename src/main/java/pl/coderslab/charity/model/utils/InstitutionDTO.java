package pl.coderslab.charity.model.utils;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
public class InstitutionDTO {

    @Id
    private Long id;
    @NotBlank
    private String name;
    private String description;
}
