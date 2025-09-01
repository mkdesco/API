package desco.ems.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UpdateResponseDTO {
    private Integer status;
    private Boolean updated;
    private List<ErrorDTO> errors;
}