package desco.ems.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GridUpdateRequestDTO {
    @NotBlank
    private String gridCurrentName;

    @NotBlank
    private String gridNewName;
}
