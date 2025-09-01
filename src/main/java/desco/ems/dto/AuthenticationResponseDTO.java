package desco.ems.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationResponseDTO {
    private Integer status;
    private List<AuthenticationDataDTO> data;
    private List<ErrorDTO> errors;
}
