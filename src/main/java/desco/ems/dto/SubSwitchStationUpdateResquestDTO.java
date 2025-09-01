package desco.ems.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SubSwitchStationUpdateResquestDTO {
    @NotBlank
    private String currentSubSwitchStationName;

    @NotBlank
    private String newSubSwitchStationName;
}
