package desco.ems.dto;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConsumerResponseSreda {
    private Integer status;
    private ConsumerDataDTO data;
    private ErrorDTO errors;
}

