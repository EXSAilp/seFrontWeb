package se.project.Web.Front.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SignupDto {
    @NotBlank
    @Size(min=4, message = "Username must have at least 4 characters.")
    private String username;

    @NotBlank
    @Size(min=8, max=128, message = "Password must have at least 8 characters.")
    private String password;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank
    private String lastName;


    @Email
    @NotBlank
    private String email;
}
