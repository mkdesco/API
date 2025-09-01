package desco.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConsumerDataDTO {
    private String accountNumber;
    private String name;
    private String meterNumber;
    private String load;
    private String tariff;
    private String officeCode;
    private String voltageLevel;
    private String siteAddress;
    private String connectionDate;
    private String connectionCategory;
    private String meterStatus;
    private String feederName;
    private String transformerName;
}