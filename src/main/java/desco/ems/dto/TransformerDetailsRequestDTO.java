package desco.ems.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransformerDetailsRequestDTO {
    @NotNull
    @Positive
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
