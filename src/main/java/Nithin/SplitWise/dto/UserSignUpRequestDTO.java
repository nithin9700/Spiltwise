package Nithin.SplitWise.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
