package rs.models;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class GoogleFormCreateDTO {
    @Schema(description = "Form content in json format")
    @NotBlank
    private String json;

    @NotBlank
    @Schema(description = "Name of the form")
    private String name;

    @Schema(description = "Date when the exam is supposed to start.")
    private LocalDateTime startDate;

    @Schema(description = "Date when the exam is supposed to end.")
    private LocalDateTime endDate;
}
