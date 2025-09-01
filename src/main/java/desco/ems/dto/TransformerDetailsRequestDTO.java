package desco.ems.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransformerDetailsRequestDTO {
    @NotBlank
    private Integer sndId;

    @NotBlank
    private String gridSubStation;

    @NotBlank
    private String subSwitchStation;

    @NotBlank
    private String feeder;

    @NotBlank
    private String transformerID;
}
