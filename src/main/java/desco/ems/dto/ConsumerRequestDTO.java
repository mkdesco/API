package desco.ems.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConsumerRequestDTO {
    @NotBlank(message = "Consumer Account Number is required.")
    private String accountNumber;
}
