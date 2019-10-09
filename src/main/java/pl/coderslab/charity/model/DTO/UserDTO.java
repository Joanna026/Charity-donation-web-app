package pl.coderslab.charity.model.DTO;

import lombok.Data;
import pl.coderslab.charity.model.entities.Role;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Role authority;

    public UserDTO() {
    }

}
