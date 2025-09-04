package desco.ems.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConsumerDataSreda {
    private String accountNumber;
    private String name;
    private String meterNumber;
    private String load;
    private String tariff;
    private String officeCode;
    private String voltageLevel;
    private String siteAddress;
}