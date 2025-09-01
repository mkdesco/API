package desco.ems.repository;

import desco.ems.dto.ConsumerDataDTO;
import desco.ems.model.NewConsumerInformation;
import desco.ems.util.ConsumerRow;
import desco.ems.util.ConsumerSredaRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewConsumerInformationRepository extends JpaRepository<NewConsumerInformation, String> {
    @Query(value =" SELECT " +
            "NCI.ACCOUNT_NO AS ACCOUNTNUMBER, " +
            "NCI.NAME AS NAME, " +
            "TO_CHAR(NCI.SANCTION_LOAD) AS LOAD, " +
            "NCI.DEPT_ID AS OFFICECODE, " +
            "NCI.SANCTION_PHASE AS VOLTAGELEVEL, " +
            "NCI.STREET_ADDRESS AS SITEADDRESS, " +
            "MT.METER_NO AS METERNUMBER, " +
            "NCI.CONNECTION_CATAGORY AS CCATEGORY, " +
            "NCI.METER_STATUS_CHILD_CHECK AS MSTATUS, " +
            "SS.FEEDER_NAME AS FEEDER, " +
            "SS.TRANSFORMER_ID AS TRANSFORMER, " +
            "EC.INSTALLED_DATE AS INSTALLATIONDATE, " +
            "CASE " +
            "   WHEN NVL(TRIM(NCI.SANCTION_TARIFF), 'A') IN ('A','A.','A1','A2','A3','AFF','123') THEN 'A' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('B') THEN 'B' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('C','C1','C.') THEN 'C1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('C2','2E','2E.') THEN 'C2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('D','D1','DD','DI') THEN 'D1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('D2','J','JI') THEN 'D2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('D3') THEN 'D3' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('E','E.','E3','EA') THEN 'E' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT1') THEN 'MT1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT2') THEN 'MT2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT3','F','F1','F3','F6') THEN 'MT3' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT4') THEN 'MT4' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT5','MF3') THEN 'MT5' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT6') THEN 'MT6' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT7') THEN 'MT7' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT8') THEN 'MT8' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT1') THEN 'HT1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT2') THEN 'HT2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT3') THEN 'HT3' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT4') THEN 'HT4' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('EHT1') THEN 'EHT1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('EHT2') THEN 'EHT2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('T') THEN 'T' " +
            "   ELSE 'A' " +
            "END AS TARIFF " +
            "FROM DESCO.NEW_CONSUMER_INFORMATION NCI " +
            "JOIN DESCO.METER_TESTING MT " +
            "ON NCI.TRACKING_NUMBER = MT.TRACKING_NUMBER " +
            "AND NCI.APPLICATION_SERIAL_NO = TO_CHAR(MT.APPLICATION_SERIAL_NO) " +
            "LEFT JOIN DESCO.SHUTDOWN_SMS_INFO_NEW SS " +
            "ON NCI.ACCOUNT_NO = TO_CHAR(SS.ACCOUNT_NO) " +
            "LEFT JOIN DESCO.EXTERNAL_CONTRACTOR EC " +
            "ON EC.APPLICATION_SERIAL_NO = TO_CHAR(NCI.APPLICATION_SERIAL_NO) " +
            "AND EC.TRACKING_NUMBER = NCI.TRACKING_NUMBER " +
            "WHERE NCI.ACCOUNT_NO = :accountNo", nativeQuery = true)
    List<ConsumerRow> findByAccountNo(@Param("accountNo") String accountNo);

    @Query(value =" SELECT " +
            "NCI.ACCOUNT_NO AS ACCOUNTNUMBER, " +
            "NCI.NAME AS NAME, " +
            "TO_CHAR(NCI.SANCTION_LOAD) AS LOAD, " +
            "NCI.DEPT_ID AS OFFICECODE, " +
            "NCI.SANCTION_PHASE AS VOLTAGELEVEL, " +
            "NCI.STREET_ADDRESS AS SITEADDRESS, " +
            "NULL AS METERNUMBER, " +
            "NCI.CONNECTION_CATAGORY AS CCATEGORY, " +
            "NCI.METER_STATUS_CHILD_CHECK AS MSTATUS, " +
            "NULL AS FEEDER, " +
            "NULL AS TRANSFORMER, " +
            "NULL AS INSTALLATIONDATE, " +
            "CASE " +
            "   WHEN NVL(TRIM(NCI.SANCTION_TARIFF), 'A') IN ('A','A.','A1','A2','A3','AFF','123') THEN 'A' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('B') THEN 'B' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('C','C1','C.') THEN 'C1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('C2','2E','2E.') THEN 'C2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('D','D1','DD','DI') THEN 'D1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('D2','J','JI') THEN 'D2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('D3') THEN 'D3' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('E','E.','E3','EA') THEN 'E' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT1') THEN 'MT1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT2') THEN 'MT2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT3','F','F1','F3','F6') THEN 'MT3' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT4') THEN 'MT4' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT5','MF3') THEN 'MT5' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT6') THEN 'MT6' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT7') THEN 'MT7' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('MT8') THEN 'MT8' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT1') THEN 'HT1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT2') THEN 'HT2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT3') THEN 'HT3' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('HT4') THEN 'HT4' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('EHT1') THEN 'EHT1' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('EHT2') THEN 'EHT2' " +
            "   WHEN TRIM(NCI.SANCTION_TARIFF) IN ('T') THEN 'T' " +
            "   ELSE 'A' " +
            "END AS TARIFF " +
            "FROM DESCO.NEW_CONSUMER_INFORMATION NCI " +
            "WHERE NCI.ACCOUNT_NO = :accountNo", nativeQuery = true)
    List<ConsumerRow> findByAccountNoWithoutJoin(@Param("accountNo") String accountNo);


    /*@Query(value =
            "select " +
                    " NCI.ACCOUNT_NO as accountNumber, " +
                    " NCI.NAME as name, " +
                    " MT.METER_NO as meterNumber, " +
                    " NCI.SANCTION_LOAD as load, " +
                    " (CASE " +
                    "   WHEN nvl(trim(nci.sanction_tariff), 'A') IN ('A','A.','A1','A2','A3','AFF','123') THEN 'A' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('B') THEN 'B' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('C','C1','C.') THEN 'C1' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('C2','2E','2E.') THEN 'C2' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('D','D1','DD','DI') THEN 'D1' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('D2','J','JI') THEN 'D2' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('D3') THEN 'D3' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('E','E.','E3','EA') THEN 'E' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT1') THEN 'MT1' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT2') THEN 'MT2' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT3','F','F1','F3','F6') THEN 'MT3' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT4') THEN 'MT4' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT5','MF3') THEN 'MT5' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT6') THEN 'MT6' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT7') THEN 'MT7' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('MT8') THEN 'MT8' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('HT1') THEN 'HT1' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('HT2') THEN 'HT2' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('HT3') THEN 'HT3' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('HT4') THEN 'HT4' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('EHT1') THEN 'EHT1' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('EHT2') THEN 'EHT2' " +
                    "   WHEN trim(nci.sanction_tariff) IN ('T') THEN 'T' " +
                    "   ELSE 'A' " +
                    "  END) as tariff, " +
                    " NCI.DEPT_ID as officeCode, " +
                    " NCI.SANCTION_PHASE as voltageLevel, " +
                    " desco.CONSUMER_ADDRESS_MVIEW(NCI.TRACKING_NUMBER, NCI.APPLICATION_SERIAL_NO) as siteAddress " +
                    " from DESCO.NEW_CONSUMER_INFORMATION nci " +
                    " join DESCO.METER_TESTING mt " +
                    "   on NCI.TRACKING_NUMBER = MT.TRACKING_NUMBER " +
                    "  and NCI.APPLICATION_SERIAL_NO = MT.APPLICATION_SERIAL_NO " +
                    " where NCI.ACCOUNT_NO = :accountNo",
            nativeQuery = true)
    List<ConsumerSredaRow> findConsumerByAccountNoForSreda(@Param("accountNo") String accountNo);*/

    /*@Query("select new desco.ems.dto.ConsumerDataDTO( " +
            "   nci.accountNo, " +
            "   nci.name, " +
            "   mt.meterNo, " +
            "   FUNCTION('TO_CHAR', nci.sanctionLoad), " +
            "   case " +
            "       when COALESCE(TRIM(UPPER(nci.sanctionTariff)),'A') in ('A','A.','A1','A2','A3','AFF','123') then 'A' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('B') then 'B' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('C','C1','C.') then 'C1' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('C2','2E','2E.') then 'C2' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('D','D1','DD','DI') then 'D1' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('D2','J','JI') then 'D2' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('D3') then 'D3' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('E','E.','E3','EA') then 'E' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT1') then 'MT1' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT2') then 'MT2' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT3','F','F1','F3','F6') then 'MT3' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT4') then 'MT4' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT5','MF3') then 'MT5' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT6') then 'MT6' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT7') then 'MT7' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('MT8') then 'MT8' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('HT1') then 'HT1' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('HT2') then 'HT2' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('HT3') then 'HT3' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('HT4') then 'HT4' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('EHT1') then 'EHT1' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('EHT2') then 'EHT2' " +
            "       when TRIM(UPPER(nci.sanctionTariff)) in ('T') then 'T' " +
            "       else 'A' " +
            "   end, " +
            "   nci.deptId, " +
            "   nci.sanctionPhase, " +
            "   nci.streetAddress, " +
            "   FUNCTION('TO_CHAR', ec.installedDate, 'YYYY-MM-DD'), " +
            "   nci.connectionCatagory, " +
            "   nci.meterStatusChildCheck, " +
            "   ss.feederName, " +
            "   ss.transformerId" +
            ") " +
            "from NewConsumerInformation nci " +
            "inner join MeterTesting mt " +
            "   on nci.trackingNumber = mt.trackingNumber " +
            "   and FUNCTION('TO_CHAR', mt.applicationSerialNo) = nci.applicationSerialNo " +
            "left join ShutdownSmsInfoNew ss " +
            "   on nci.accountNo = FUNCTION('TO_CHAR', ss.accountNo) " +
            "left join ExternalContractor ec " +
            "   on nci.trackingNumber = ec.trackingNumber " +
            "   and nci.applicationSerialNo = FUNCTION('TO_CHAR', ec.applicationSerialNo) " +
            "where nci.accountNo = :accountNo")
    List<ConsumerDataDTO> findByAccountNoJpql(@Param("accountNo") String accountNo);*/
}