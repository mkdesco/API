package desco.ems.dto;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConsumerResponseDTO {
    private Integer status;
    private List<ConsumerDataDTO> data;
    private List<ErrorDTO> errors;
}
