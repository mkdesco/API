package desco.ems.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BILL_CALCULATION", schema = "DESCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillCalculation {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "ACCOUNT_NO", length = 20)
    private String accountNo;

    @Column(name = "METER_NO", length = 20)
    private String meterNo;

    @Column(name = "TEMP", length = 1)
    private String temp;

    @Column(name = "YEAR", precision = 38)
    private BigDecimal year;

    @Column(name = "MONTH", precision = 38)
    private BigDecimal month;

    @Column(name = "BILL_NO", length = 20)
    private String billNo;

    @Column(name = "CURRENT_RD", precision = 38, scale = 2)
    private BigDecimal currentRd;

    @Column(name = "PREV_RD", precision = 38, scale = 2)
    private BigDecimal prevRd;

    @Column(name = "OFF_CURRENT_RD", precision = 38, scale = 2)
    private BigDecimal offCurrentRd;

    @Column(name = "OFF_PREV_RD", precision = 38, scale = 2)
    private BigDecimal offPrevRd;

    @Column(name = "UNIT_CONSUMED", precision = 38, scale = 2)
    private BigDecimal unitConsumed;

    @Column(name = "MAX_DEMAND", precision = 38, scale = 2)
    private BigDecimal maxDemand;

    @Column(name = "ENERGY_AMOUNT", precision = 38, scale = 2)
    private BigDecimal energyAmount;

    @Column(name = "DEMAND_CHARGE", precision = 38, scale = 2)
    private BigDecimal demandCharge;

    @Column(name = "ESTIMATED_CHARGE", precision = 38, scale = 2)
    private BigDecimal estimatedCharge;

    @Column(name = "SERVICE_CHARGE", precision = 38, scale = 2)
    private BigDecimal serviceCharge;

    @Column(name = "NET_AMOUNT", precision = 38, scale = 2)
    private BigDecimal netAmount;

    @Column(name = "TOTAL_AMOUNT", precision = 38, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "TYPE", length = 4)
    private String type;

    @Column(name = "VAT_TOTAL", precision = 38, scale = 2)
    private BigDecimal vatTotal;

    @Column(name = "PFC", precision = 38, scale = 2)
    private BigDecimal pfc;

    @Column(name = "K_VARH", precision = 38, scale = 2)
    private BigDecimal kVarh;

    @Column(name = "MAX_LOAD", precision = 38, scale = 2)
    private BigDecimal maxLoad;

    @Column(name = "PROCESSED", length = 1)
    private String processed;

    @Column(name = "MIN", length = 1)
    private String min;

    @Column(name = "READING_DATE")
    private LocalDate readingDate;

    @Column(name = "STARTING_DATE")
    private LocalDate startingDate;

    @Column(name = "CORRECTION_FACTOR", precision = 38, scale = 2)
    private BigDecimal correctionFactor;

    @Column(name = "TIMER", precision = 38, scale = 2)
    private BigDecimal timer;

    @Column(name = "DAYS", precision = 38, scale = 2)
    private BigDecimal days;

    @Column(name = "PROBLEM", precision = 38, scale = 2)
    private BigDecimal problem;

    @Column(name = "OFF_KVARH", precision = 38, scale = 2)
    private BigDecimal offKvarh;

    @Column(name = "ENTRY_DATE")
    private LocalDate entryDate;

    @Column(name = "OFF_UNIT_CONSUMED", precision = 38, scale = 2)
    private BigDecimal offUnitConsumed;

    @Column(name = "OFF_ENERGY_AMOUNT", precision = 38, scale = 2)
    private BigDecimal offEnergyAmount;

    @Column(name = "OLD_ACCOUNT_NO", length = 20)
    private String oldAccountNo;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "OFF_PFC", precision = 38, scale = 2)
    private BigDecimal offPfc;

    @Column(name = "METER_RENT", precision = 38, scale = 2)
    private BigDecimal meterRent;

    @Column(name = "PEAK_ENERGY_AMOUNT", precision = 38, scale = 2)
    private BigDecimal peakEnergyAmount;

    @Column(name = "RESET", length = 10)
    private String reset;

    @Column(name = "PRINT", length = 2)
    private String print;

    @Column(name = "X_RENT", precision = 38, scale = 2)
    private BigDecimal xRent;

    @Column(name = "METER_MANUFACTURER_CODE", precision = 38, scale = 2)
    private BigDecimal meterManufacturerCode;

    @Column(name = "ADJUSTMENT", precision = 38, scale = 2)
    private BigDecimal adjustment;

    @Column(name = "OFF_PFC_RD", precision = 38, scale = 2)
    private BigDecimal offPfcRd;

    @Column(name = "OFF_PFC_CHARGE", precision = 38, scale = 2)
    private BigDecimal offPfcCharge;

    @Column(name = "PEAK_PFC_RD", precision = 38, scale = 2)
    private BigDecimal peakPfcRd;

    @Column(name = "PEAK_PFC_CHARGE", precision = 38, scale = 2)
    private BigDecimal peakPfcCharge;

    @Column(name = "OFF_X_ER_LOSS_RD", precision = 38, scale = 2)
    private BigDecimal offXErLossRd;

    @Column(name = "OFF_X_ER_LOSS_CHARGE", precision = 38, scale = 2)
    private BigDecimal offXErLossCharge;

    @Column(name = "PEAK_X_ER_LOSS_RD", precision = 38, scale = 2)
    private BigDecimal peakXErLossRd;

    @Column(name = "PEAK_X_ER_LOSS_CHARGE", precision = 38, scale = 2)
    private BigDecimal peakXErLossCharge;

    @Column(name = "MIN_AMOUNT", precision = 38, scale = 2)
    private BigDecimal minAmount;

    @Column(name = "PREV_DATE")
    private LocalDate prevDate;

    @Column(name = "KW_READ", precision = 38, scale = 2)
    private BigDecimal kwRead;

    @Column(name = "TYPE_ESTIMATED", length = 9)
    private String typeEstimated;

    @Column(name = "TBM", precision = 38, scale = 2)
    private BigDecimal tbm;

    @Column(name = "PROBLEM_SEQUENCE_STRING", length = 200)
    private String problemSequenceString;

    @Column(name = "BILLED", precision = 38, scale = 2)
    private BigDecimal billed;

    @Column(name = "OFF_PREV_RD_FORM", precision = 38, scale = 2)
    private BigDecimal offPrevRdForm;

    @Column(name = "PEAK_PREV_RD_FORM", precision = 38, scale = 2)
    private BigDecimal peakPrevRdForm;

    @Column(name = "K_VARH_FORM", precision = 38, scale = 2)
    private BigDecimal kVarhForm;

    @Column(name = "OFF_KVARH_FORM", precision = 38, scale = 2)
    private BigDecimal offKvarhForm;

    @Column(name = "K_VARH_PREV", precision = 38, scale = 2)
    private BigDecimal kVarhPrev;

    @Column(name = "OFF_K_VARH_PREV", precision = 38, scale = 2)
    private BigDecimal offKVarhPrev;

    @Column(name = "CHECKED", precision = 38, scale = 2)
    private BigDecimal checked;

    @Column(name = "REMARKS", length = 40)
    private String remarks;

    @Column(name = "BYPASS_ERR", length = 2)
    private String bypassErr;

    @Column(name = "DEPT_ID", length = 3)
    private String deptId;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "PAID", length = 1)
    private String paid;

    @Column(name = "BC_POSTED", length = 1)
    private String bcPosted;

    @Column(name = "REMOTE_POSTED", precision = 38, scale = 2)
    private BigDecimal remotePosted;

    @Column(name = "ADJ_BILL", precision = 38, scale = 2)
    private BigDecimal adjBill;

    @Column(name = "LPC", precision = 38, scale = 2)
    private BigDecimal lpc;

    @Column(name = "OLD_OLD_ACCOUNT_NO", length = 20)
    private String oldOldAccountNo;

    @Column(name = "TARIFF", length = 20)
    private String tariff;

    @Column(name = "BATCH_BL", length = 8)
    private String batchBl;

    @Column(name = "TOTAL_KWH", precision = 38, scale = 2)
    private BigDecimal totalKwh;

    @Column(name = "CHILD_OFF_SUM", precision = 38, scale = 2)
    private BigDecimal childOffSum;

    @Column(name = "CHILD_PEAK_SUM", precision = 38, scale = 2)
    private BigDecimal childPeakSum;

    @Column(name = "OLD_OLD_OLD_ACCOUNT_NO", length = 20)
    private String oldOldOldAccountNo;

    @Column(name = "BATCH_GP", length = 10)
    private String batchGp;

    @Column(name = "BATCH_CITYB", length = 10)
    private String batchCityb;

    @Column(name = "ORGANIZATION_CODE", precision = 2)
    private BigDecimal organizationCode;

    @Column(name = "BATCH_BA", length = 10)
    private String batchBa;

    @Column(name = "BATCH_SE", length = 10)
    private String batchSe;

    @Column(name = "BATCH_OB", length = 10)
    private String batchOb;

    @Column(name = "BATCH_AB", length = 10)
    private String batchAb;

    @Column(name = "BATCH_SSL", length = 10)
    private String batchSsl;

    @Column(name = "BATCH_NRBC", length = 10)
    private String batchNrbc;

    @Column(name = "BATCH_MTB", length = 10)
    private String batchMtb;

    @Column(name = "BATCH_SIBL", length = 10)
    private String batchSibl;

    @Column(name = "BATCH_MMBL", length = 10)
    private String batchMmbl;

    @Column(name = "BATCH_SJIBL", length = 10)
    private String batchSjibl;

    @Column(name = "BATCH_NBL", length = 10)
    private String batchNbl;

    @Column(name = "BATCH_MDLB", length = 10)
    private String batchMdlb;

    @Column(name = "BATCH_PBL", length = 10)
    private String batchPbl;

    @Column(name = "BATCH_ROBI", length = 10)
    private String batchRobi;

    @Column(name = "BATCH_FSIBL", length = 10)
    private String batchFsibl;

    @Column(name = "BATCH_NCCB", length = 10)
    private String batchNccb;

    @Column(name = "BATCH_STDBANK", length = 10)
    private String batchStdbank;

    @Column(name = "BATCH_BASIC", length = 10)
    private String batchBasic;

    @Column(name = "COLLECTION_DATE")
    private LocalDate collectionDate;

    @Column(name = "BATCH_UNION", length = 10)
    private String batchUnion;

    @Column(name = "BATCH_SMS", length = 10)
    private String batchSms;

    @Column(name = "BATCH_EXIM", length = 10)
    private String batchExim;

    @Column(name = "BATCH_MEGHNABL", length = 10)
    private String batchMeghnabl;

    @Column(name = "BATCH_BCBL", length = 10)
    private String batchBcbl;

    @Column(name = "BATCH_IPAY", length = 10)
    private String batchIpay;

    @Column(name = "BATCH_AIBL", length = 10)
    private String batchAibl;

    @Column(name = "BATCH_DBBL", length = 10)
    private String batchDbbl;

    @Column(name = "TOTAL_PAID_AMOUNT", precision = 38, scale = 2)
    private BigDecimal totalPaidAmount;

    @Column(name = "BATCH_IBL", length = 10)
    private String batchIbl;

    @Column(name = "BATCH_UCB", length = 10)
    private String batchUcb;

    @Column(name = "BATCH_BKASH", length = 10)
    private String batchBkash;

    @Column(name = "BATCH_AGRANIBL", length = 10)
    private String batchAgranibl;

    @Column(name = "BATCH_PUBALIBL", length = 10)
    private String batchPubalibl;
}