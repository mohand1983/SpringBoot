package fr.aelion.streamer.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStudentDto {
    @NotBlank(message = "Last name can not be null")
    private String lastName;
    private String firstName;
    @NotBlank
    @Email
    private String email;

    private String phoneNumber;
    @NotBlank
    @Min(8)
    @Size(min = 8, message = ("Login must have at loast 8 chars"))
    private String login;
    @NotBlank
    @Min(8)
    @Size(min = 8, message = ("Password must have at loast 8 chars"))
    @Pattern(regexp = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/")
    private String password;

}
