package desco.ems.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private Integer Status;
    private T Data = (T) new Object();
    private List<ErrorDTO> errors = new ArrayList<>();
}
