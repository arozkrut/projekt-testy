package rs.models;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GoogleFormCreateDTO {
    @Schema(description = "Form content in json format")
    @NotBlank
    private String json;

    @NotBlank
    @Schema(description = "Name of the form")
    private String name;
}
