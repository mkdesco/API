package desco.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentRequestDTO extends ConsumerRequestDTO {
    private String paymentStatus;
}
