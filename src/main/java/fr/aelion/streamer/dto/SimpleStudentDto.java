package fr.aelion.streamer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleStudentDto {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
}
