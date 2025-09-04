package desco.ems.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
