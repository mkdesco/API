package desco.ems.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransformerDetailsResponseDTO {
    private Integer status;
    private List<XformerDetails> data;
    private List<ErrorDTO> errors;
}
