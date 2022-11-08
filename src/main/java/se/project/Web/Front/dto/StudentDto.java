package se.project.Web.Front.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class StudentDto {

    private UUID id;
    @NotBlank
    private String studentId;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String email;
    @NotBlank
    private String subject;
    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private double score;
    @NotBlank
    private String teacher;
}
