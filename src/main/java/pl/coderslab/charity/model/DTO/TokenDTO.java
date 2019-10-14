package pl.coderslab.charity.model.DTO;

import lombok.Data;
import pl.coderslab.charity.model.entities.User;
import java.util.Date;

@Data
public class TokenDTO {

    private String token;
    private User user;
    private Date expiryDate;
}
