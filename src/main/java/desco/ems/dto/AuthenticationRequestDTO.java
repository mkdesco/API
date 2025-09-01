package desco.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationRequestDTO {
    private String username;
    private String password;
}
