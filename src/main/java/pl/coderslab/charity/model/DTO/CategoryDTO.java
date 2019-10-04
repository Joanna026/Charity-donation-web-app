package pl.coderslab.charity.model.DTO;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
public class CategoryDTO {

    @Id
    private Long id;
    @NotBlank
    private String name;
}
