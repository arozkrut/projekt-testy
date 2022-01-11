package rs.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
public class GoogleFormDTO {
    @NotNull(message = "Id can't be null")
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "Form content in json format")
    @NotBlank
    private String json;

    @NotBlank
    @Schema(description = "Name of the form")
    private String name;
}
