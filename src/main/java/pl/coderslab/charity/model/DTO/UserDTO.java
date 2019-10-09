package pl.coderslab.charity.model.DTO;

import lombok.Data;
import pl.coderslab.charity.model.entities.Role;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Role authority;

    public UserDTO() {
    }
}
