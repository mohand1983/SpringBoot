package fr.aelion.streamer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCourseDto {
    @NotBlank(message = "Title can not be empty")
    private String title;
    private String objective;

}
