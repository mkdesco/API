package desco.ems.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FeederUpdateRequestDTO {
    @NotBlank
    private String feederCurrentName;

    @NotBlank
    private String feederNewName;
}
