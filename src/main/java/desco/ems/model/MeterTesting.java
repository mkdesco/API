package desco.ems.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "METER_TESTING", schema = "DESCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeterTesting {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "TRACKING_NUMBER", length = 11)
    private String trackingNumber;

    @Column(name = "METER_NO", length = 20)
    private String meterNo;

    @Column(name = "APPLICATION_SERIAL_NO")
    private BigDecimal applicationSerialNo;

    @Column(name = "ENTRY_DATE")
    private LocalDate entryDate;

    @Column(name = "METER_ENABLE", length = 1)
    private String meterEnable;

    @Column(name = "METER_SOURCE", length = 10)
    private String meterSource;

    @Column(name = "METER_MANUFACTURER_CODE")
    private BigDecimal meterManufacturerCode;

    @Column(name = "PREVIOUS_METER_NO", length = 50)
    private String previousMeterNo;

    @Column(name = "PREVIOUS_M_M_CODE")
    private BigDecimal previousMMCode;

    @Column(name = "ACCOUNT_NO")
    private BigDecimal accountNo;

    @Column(name = "INSTALLED_DATE")
    private LocalDate installedDate;

    @Column(name = "DISABLE_DATE")
    private LocalDate disableDate;

    @Column(name = "CMO_DATE")
    private LocalDate cmoDate;

    @Column(name = "CMO_BY", length = 20)
    private String cmoBy;

    @Column(name = "CANCELLED_DATE")
    private LocalDate cancelledDate;

    @Column(name = "CANCELLED_BY", length = 20)
    private String cancelledBy;

    @Column(name = "REMOTE_POSTED", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT '0'")
    private String remotePosted;

    @Column(name = "DEPARTMENT_ID", length = 3)
    private String departmentId;

}