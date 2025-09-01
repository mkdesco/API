package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "NEW_CONSUMER_INFORMATION", schema = "DESCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewConsumerInformation {
    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "TRACKING_NUMBER", length = 11)
    private String trackingNumber;

    @Column(name = "APPLICATION_SERIAL_NO_")
    private BigDecimal applicationSerialNo_;

    @Column(name = "APPLIED_TARIFF", length = 5)
    private String appliedTariff;

    @Column(name = "APPLICATION_TYPE", length = 40)
    private String applicationType;

    @Column(name = "CONNECTION_TYPE", length = 40)
    private String connectionType;

    @Column(name = "CONSUMER_TYPE", length = 52)
    private String consumerType;

    @Column(name = "PLOT_NO", length = 110)
    private String plotNo;

    @Column(name = "HOUSE_FLAT_NO", length = 100)
    private String houseFlatNo;

    @Column(name = "BLOCK_NO", length = 80)
    private String blockNo;

    @Column(name = "STREET_ADDRESS", length = 500)
    private String streetAddress;

    @Column(name = "THANA", length = 72)
    private String thana;

    @Column(name = "AREA", length = 125)
    private String area;

    @Column(name = "ZIP_CODE", length = 60)
    private String zipCode;

    @Column(name = "TITLE", length = 20)
    private String title;

    @Column(name = "SEX", length = 10)
    private String sex;

    @Column(name = "ROAD_NO", length = 70)
    private String roadNo;

    @Column(name = "LAND_PHONE", length = 20)
    private String landPhone;

    @Column(name = "MOBILE_NO", length = 15)
    private String mobileNo;

    @Column(name = "EMAIL_ADDRESS", length = 70)
    private String emailAddress;

    @Column(name = "MEMBER_ID")
    private BigDecimal memberId;

    @Column(name = "ACCOUNT_NO", length = 20)
    private String accountNo;

    @Column(name = "FATHER_ORG", length = 50)
    private String fatherOrg;

    @Column(name = "BLOCK_BILL", length = 25)
    private String blockBill;

    @Column(name = "SANCTION_TARIFF", length = 20)
    private String sanctionTariff;

    @Column(name = "SANCTION_PHASE", length = 10)
    private String sanctionPhase;

    @Column(name = "TYPE_CLASSIFICATION", length = 30)
    private String typeClassification;

    @Column(name = "CONSUMER_BIRTH_DATE")
    private LocalDate consumerBirthDate;

    @Column(name = "MOTHER_ORG_NAME", length = 100)
    private String motherOrgName;

    @Column(name = "TYPE_CODE", precision = 2)
    private BigDecimal typeCode;

    @Column(name = "ROUTE_NUMBER")
    private BigDecimal routeNumber;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "CONNECTION_STATUS_CODE")
    private BigDecimal connectionStatusCode;

    @Column(name = "PRE_APP_DATE")
    private LocalDate preAppDate;

    @Column(name = "APPLIED_PHASE", precision = 1)
    private BigDecimal appliedPhase;

    @Column(name = "LAND_OWNER_NAME", length = 40)
    private String landOwnerName;

    @Column(name = "LAND_OWNER_FATHER_NAME", length = 40)
    private String landOwnerFatherName;

    @Column(name = "CONTACT_DATE")
    private LocalDate contactDate;

    @Column(name = "MAIN_APP_DATE")
    private LocalDate mainAppDate;

    @Column(name = "APPLIED_LOAD", precision = 5)
    private BigDecimal appliedLoad;

    @Column(name = "APPLIED_VOLTAGE", precision = 6)
    private BigDecimal appliedVoltage;

    @Column(name = "SPECIAL_CLASS", precision = 2)
    private BigDecimal specialClass;

    @Column(name = "ORGANIZATION_CODE", precision = 2)
    private BigDecimal organizationCode;

    @Column(name = "DISTANCE_POLE_METER", precision = 5)
    private BigDecimal distancePoleMeter;

    @Column(name = "APPLICATION_BUNDLE_NO")
    private BigDecimal applicationBundleNo;

    @Column(name = "SANCTION_LOAD")
    private BigDecimal sanctionLoad;

    @Column(name = "SECTION_NO", length = 60)
    private String sectionNo;

    @Column(name = "CONNECTION_CATAGORY", length = 3)
    private String connectionCatagory;

    @Column(name = "METER_STATUS_CHILD_CHECK", length = 20)
    private String meterStatusChildCheck;

    @Column(name = "ACCOUNT_CHECK_METER", length = 20)
    private String accountCheckMeter;

    @Column(name = "METER_SIDE_LT_HT", length = 20)
    private String meterSideLtHt;

    @Column(name = "X_FORMER_LOSS", length = 5)
    private String xFormerLoss;

    @Column(name = "RENTAL_FEES")
    private BigDecimal rentalFees;

    @Column(name = "SANCTION_PART")
    private BigDecimal sanctionPart;

    @Column(name = "APPLIED_PART")
    private BigDecimal appliedPart;

    @Column(name = "APPROVAL_STATUS")
    private BigDecimal approvalStatus;

    @Column(name = "CHANGE_METER")
    private BigDecimal changeMeter;

    @Column(name = "BILLING_ZONE", length = 10)
    private String billingZone;

    @Column(name = "LOAD_SANCTION_COMMENT", length = 100)
    private String loadSanctionComment;

    @Column(name = "OTHERS_NAME", length = 40)
    private String othersName;

    @Column(name = "CONNECTION_AMOUNT")
    private BigDecimal connectionAmount;

    @Column(name = "OCCUPENT_NAME", length = 30)
    private String occupentName;

    @Column(name = "MAILING_ADDRESS", length = 100)
    private String mailingAddress;

    @Column(name = "OLD_ACCOUNT_NO", length = 20)
    private String oldAccountNo;

    @Column(name = "OLD_OLD_ACCOUNT_NO", length = 20)
    private String oldOldAccountNo;

    @Column(name = "PASSWORD", length = 20)
    private String password;

    @Column(name = "MINISTRY", length = 100)
    private String ministry;

    @Column(name = "ACCOUNT_ENABLE")
    private BigDecimal accountEnable;

    @Column(name = "CONTACT_HOUSE", length = 15)
    private String contactHouse;

    @Column(name = "CONTACT_STREET", length = 60)
    private String contactStreet;

    @Column(name = "CONTACT_POSTAL", length = 10)
    private String contactPostal;

    @Column(name = "APPLICATION_SERIAL_NO", length = 10)
    private String applicationSerialNo;

    @Column(name = "INFO_WITHIN")
    private LocalDate infoWithin;

    @Column(name = "DEPT_ID", length = 3)
    private String deptId;

    @Column(name = "CLR_CERTFICATE_YR", length = 4)
    private String clrCertficateYr;

    @Column(name = "BATCH_BL", length = 8)
    private String batchBl;

    @Column(name = "RETURN_BILL_NO", length = 200)
    private String returnBillNo;

    @Column(name = "RETURN_AMOUNT_TK")
    private BigDecimal returnAmountTk;

    @Column(name = "RETURN_BILL_TYPE", length = 30)
    private String returnBillType;

    @Column(name = "EFFECTIVE_FROM")
    private LocalDate effectiveFrom;

    @Column(name = "OLD_OLD_OLD_ACCOUNT_NO", length = 20)
    private String oldOldOldAccountNo;

    @Column(name = "BATCH_CITYB", length = 10)
    private String batchCityb;

    @Column(name = "BATCH_BA", length = 10)
    private String batchBa;

    @Column(name = "BATCH_SE", length = 10)
    private String batchSe;

    @Column(name = "BATCH_OB", length = 10)
    private String batchOb;

    @Column(name = "BATCH_GP", length = 10)
    private String batchGp;

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

    @Column(name = "BATCH_UNION", length = 10)
    private String batchUnion;

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

    @Column(name = "XLOCATION")
    private BigDecimal xlocation;

    @Column(name = "YLOCATION")
    private BigDecimal ylocation;

    @Column(name = "BASTI_ALLOTEE_NO")
    private BigDecimal bastiAlloteeNo;

}
