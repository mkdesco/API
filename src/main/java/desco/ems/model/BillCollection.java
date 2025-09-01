package desco.ems.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BILL_COLLECTION", schema = "DESCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillCollection {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "BILL_NO", length = 25, nullable = false)
    private String billNo;

    @Column(name = "BUNDLE_NO", length = 10)
    private String bundleNo;

    @Column(name = "BANK_CODE", length = 10)
    private String bankCode;

    @Column(name = "SCROLL_NO", length = 10)
    private String scrollNo;

    @Column(name = "COLLECTION_DATE")
    private LocalDate collectionDate;

    @Column(name = "TOTAL_PAYABLE_AMOUNT", precision = 38, scale = 2)
    private BigDecimal totalPayableAmount;

    @Column(name = "TOTAL_PAID_AMOUNT", precision = 38, scale = 2)
    private BigDecimal totalPaidAmount;

    @Column(name = "LPC", precision = 38, scale = 2)
    private BigDecimal lpc;

    @Column(name = "PAID", length = 1)
    private String paid;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "DEPT_ID", length = 3)
    private String deptId;

    @Column(name = "REMOTE_POSTED", length = 3)
    private String remotePosted;

    @Column(name = "TARIFF", length = 20)
    private String tariff;

    @Column(name = "BATCH_GP", length = 10)
    private String batchGp;

    @Column(name = "ENTRY_DATE")
    private LocalDate entryDate;

    @Column(name = "BATCH_SMS", length = 10)
    private String batchSms;
}