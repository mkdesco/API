package desco.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationDataDTO {
    private String accessToken;
    private Integer expiresIn;
    private String createTimeStamp;
}
