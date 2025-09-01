package desco.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class XformerDetails {
    private String transformerID;
    private String feeder;
    private String subSwitchStation;
    private String griSubStation;
    private String totalAmpsR;
    private String totalAmpsY;
    private String totalAmpsB;
    private String maxAmpsN;
    private String xfAverageAmps;
    private String xfMaxAmpsRecordDate;
    private String lastMaintenanceDate;
    private String nextMaintenanceDate;
}