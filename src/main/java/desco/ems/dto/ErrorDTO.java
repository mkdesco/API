package desco.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ErrorDTO {
    private String code;
    private String message;
}
