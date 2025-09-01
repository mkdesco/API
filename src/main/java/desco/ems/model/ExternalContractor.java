package desco.ems.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EXTERNAL_CONTRACTOR", schema = "DESCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalContractor {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "TRACKING_NUMBER", length = 11)
    private String trackingNumber;

    @Column(name = "APPLICATION_SERIAL_NO")
    private BigDecimal applicationSerialNo;

    @Column(name = "MEGAR_SPECIFICATION", length = 20)
    private String megarSpecification;

    @Column(name = "EARTH_TEST_SPECIFICATION", length = 20)
    private String earthTestSpecification;

    @Column(name = "ELECTRICAL_WIRING")
    private BigDecimal electricalWiring;

    @Column(name = "INSPECTION_DATE")
    private LocalDate inspectionDate;

    @Column(name = "SUBMISSION_DATE")
    private LocalDate submissionDate;

    @Column(name = "REPORTED_BY", length = 60)
    private String reportedBy;

    @Column(name = "INSTALLED_BY", length = 60)
    private String installedBy;

    @Column(name = "INSTALLED_DATE")
    private LocalDate installedDate;

    @Column(name = "INT_WIRING_COMPLETE")
    private BigDecimal intWiringComplete;

    @Column(name = "METER_BOARD_INSTALLED")
    private BigDecimal meterBoardInstalled;

    @Column(name = "SERVICE_WIRE_VIEWABLE")
    private BigDecimal serviceWireViewable;

    @Column(name = "DIST_PIPE_BOARD")
    private BigDecimal distPipeBoard;

    @Column(name = "EARTHING_COMPLETE")
    private BigDecimal earthingComplete;

    @Column(name = "OTHERS")
    private BigDecimal others;

    @Column(name = "COMMENTS", length = 200)
    private String comments;

    @Column(name = "DEPT_ID", length = 10)
    private String deptId;

}
