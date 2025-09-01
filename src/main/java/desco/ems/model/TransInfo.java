package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TRANSINFO",  schema = "XFORMERDB")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TransInfoSeq")
    @SequenceGenerator(name = "TransInfoSeq", allocationSize = 1, sequenceName = "TRANSINFOSEQ")
    @Column(name = "TRANSFORMER_INFO_ID", nullable = false, updatable = false)
    private Integer transInfoId;

    @Column(name = "TRANSFORMER_PHASE", updatable = true)
    private String transPhase;

    @Column(name = "LT_SIDE_FEED", updatable = true)
    private String transLTFeed;

    @Column(name = "TRANSFORMER_CAPACITY_1", updatable = true)
    private Double transCapacity1;

    @Column(name = "TRANSFORMER_CAPACITY_2", updatable = true)
    private Double transCapacity2;

    @Column(name = "TRANSFORMER_CAPACITY_3", updatable = true)
    private Double transCapacity3;

    @Column(name = "TRANSFORMER_VOLTAGE_LEVEL", updatable = true)
    private String transVoltLevel;

    @Column(name = "LEFT_XF_LOAD_R", updatable = true)
    private Double transLeftRLoad;

    @Column(name = "LEFT_XF_LOAD_Y", updatable = true)
    private Double transLeftYLoad;

    @Column(name = "LEFT_XF_LOAD_B", updatable = true)
    private Double transLeftBLoad;

    @Column(name = "LEFT_XF_LOAD_N", updatable = true)
    private Double transLeftNLoad;

    @Column(name = "RIGHT_XF_LOAD_R", updatable = true)
    private Double transRightRLoad;

    @Column(name = "RIGHT_XF_LOAD_Y", updatable = true)
    private Double transRightYLoad;

    @Column(name = "RIGHT_XF_LOAD_B", updatable = true)
    private Double transRightBLoad;

    @Column(name = "RIGHT_XF_LOAD_N", updatable = true)
    private Double transRightNLoad;

    @Column(name = "TOTAL_LOAD_R", updatable = true)
    private Double transTotalRLoad;

    @Column(name = "TOTAL_LOAD_Y", updatable = true)
    private Double transTotalYLoad;

    @Column(name = "TOTAL_LOAD_B", updatable = true)
    private Double transTotalBLoad;

    @Column(name = "MAX_LOAD_N", updatable = true)
    private Double transMaxNLoad;

    @Column(name = "AVG_AMPS_OF_XF", updatable = true)
    private Double transAvgAmp;

    @Column(name = "ALLOCATED_LOAD_KW", updatable = true)
    private Double transAllocLoad;

    @Column(name = "FEEDER_LOAD", updatable = true)
    private Double transFeederLoad;

    @Column(name = "FEEDER_BREAKER_SIZE", updatable = true)
    private Double transFeederBrkSize;

    @Column(name = "BREAKER_HIGHEST_LOAD", updatable = true)
    private Double transBrkMaxLoad;

    @Column(name = "FEEDER_PEAK_LOAD_DATE", updatable = true)
    private String transFeederPeakLoadDt;

    @Column(name = "XF_OWNER", updatable = true)
    private String transOwner;

    @Column(name = "INSTALLED_TYPE_1", updatable = true)
    private String transInstallType1;

    @Column(name = "INSTALLED_TYPE_2", updatable = true)
    private String transInstallType2;

    @Column(name = "INSTALLED_TYPE_3", updatable = true)
    private String transInstallType3;

    @Column(name = "COUNTRY_1", updatable = true)
    private String transManuCountry1;

    @Column(name = "COUNTRY_2", updatable = true)
    private String transManuCountry2;

    @Column(name = "COUNTRY_3", updatable = true)
    private String transManuCountry3;

    @Column(name = "MANUFACTURER_1", updatable = true)
    private String transManufacturer1;

    @Column(name = "MANUFACTURER_2", updatable = true)
    private String transManufacturer2;

    @Column(name = "MANUFACTURER_3", updatable = true)
    private String transManufacturer3;

    @Column(name = "MANUFACTURER_YEAR_1", updatable = true)
    private String transManuYear1;

    @Column(name = "MANUFACTURER_YEAR_2", updatable = true)
    private String transManuYear2;

    @Column(name = "MANUFACTURER_YEAR_3", updatable = true)
    private String transManuYear3;

    @Column(name = "TRANSFORMER_SL_1", updatable = true)
    private String transSerial1;

    @Column(name = "TRANSFORMER_SL_2", updatable = true)
    private String transSerial2;

    @Column(name = "TRANSFORMER_SL_3", updatable = true)
    private String transSerial3;

    @Column(name = "LT_SIDE_PDATA", updatable = true)
    private String transLTProtect;

    @Column(name = "HT_SIDE_PDATA_R", updatable = true)
    private String transHTProtectR;

    @Column(name = "HT_SIDE_LA_R", updatable = true)
    private String transHTLAR;

    @Column(name = "HT_SIDE_PDATA_Y", updatable = true)
    private String transHTProtectY;

    @Column(name = "HT_SIDE_LA_Y", updatable = true)
    private String transHTLAY;

    @Column(name = "HT_SIDE_PDATA_B", updatable = true)
    private String transHTProtectB;

    @Column(name = "HT_SIDE_LA_B", updatable = true)
    private String transHTLAB;

    @Column(name = "OIL_LEVEL", updatable = true)
    private String transOilLevelStatus;

    @Column(name = "NO_OF_EARTHING", updatable = true)
    private String transEarthingCount;

    @Column(name = "UPDATE_FOR", updatable = true)
    private String transUpdateReason;

    @Column(name = "TRANSFORMER_LOCATION", updatable = true)
    private String transLocation;

    @Column(name = "COMMENTS", updatable = true)
    private String commentsOnTransEntry;

    @Column(name = "ACTIVE_STATUS", updatable = true)
    private String transActiveStatus;

    @Column(name = "WELDING", updatable = true)
    private String transWeldingStatus;

    @Column(name = "NOS_OF_CONSUMERS", updatable = true)
    private Double transConsumersCount;

    @Column(name = "OIL_DIELECTRIC_STRENGTH", updatable = true)
    private Double transDielecStrength;

    @Column(name = "EARTH_RESISTANCE_LEFT", updatable = true)
    private Double transEarthResistanceLeft;

    @Column(name = "EARTH_RESISTANCE_RIGHT", updatable = true)
    private Double transEarthResistanceRight;

    @Column(name = "REPORT_DATE", updatable = true)
    private String transReportDate;

    @Column(name = "XF_AMPS_DATE", updatable = true)
    private String transAmpDate;

    @Column(name = "CONSUMER_UPDATE", updatable = true)
    private String transConsumerCountDate;

    @Column(name = "OIL_DIELECTRIC_DATE", updatable = true)
    private String transDielecDate;

    @Column(name = "EARTH_RESISTANCE_DATE", updatable = true)
    private String transEarthResistDate;

    @Column(name = "DATE_OF_INSTALLATION", updatable = true)
    private String transInstallDate;

    @Column(name = "PROPOSED_M_DATE", updatable = true)
    private String transNextMaintenanceDate;

    @Column(name = "LAST_MAINTENANCE", updatable = true)
    private String transLastMaintenanceDate;

    @Column(name = "UPDATE_ENTRY", updatable = true)
    private String transEntryUpdateDate;

    @Column(name = "UPDATE_BY", updatable = true)
    private String transEntryUpdatedBy;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TransformerEntity.class)
    @JoinColumn(name = "TRANSFORMER_ID", nullable = false, updatable = false)
    private TransformerEntity objTransformer;

}
