package desco.ems.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PaymentResponseDTO {
    private Integer status;
    private List<PaymentDataDTO> data;
    private List<ErrorDTO> errors;
}
