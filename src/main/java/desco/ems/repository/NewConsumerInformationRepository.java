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
            "MT.METER_NO AS METERNUMBER, " +
            "NCI.CONNECTION_CATAGORY AS CCATEGORY, " +
            "NCI.METER_STATUS_CHILD_CHECK AS MSTATUS, " +
            "SS.FEEDER_NAME AS FEEDER, " +
            "SS.TRANSFORMER_ID AS TRANSFORMER, " +
            "EC.INSTALLED_DATE AS INSTALLATIONDATE, " +
            "  (CASE\n" +
            "\n" +
            "                   WHEN nvl(trim(nci.sanction_tariff), 'A') IN\n" +
            "                           ('A', 'A.', 'A1', 'A2', 'A3', 'AFF','123')\n" +
            "                   THEN\n" +
            "                      1\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('B')\n" +
            "                   THEN\n" +
            "                      2\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('C', 'C1','C.')\n" +
            "                   THEN\n" +
            "                      3\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('C2','2E', '2E.')\n" +
            "                   THEN\n" +
            "                      4\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('D', 'D1', 'DD', 'DI')\n" +
            "                   THEN\n" +
            "                      5\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('D2', 'J', 'JI')\n" +
            "                   THEN\n" +
            "                      6\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('D3')\n" +
            "                   THEN\n" +
            "                      7\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('E', 'E.','E3','EA')\n" +
            "                   THEN\n" +
            "                      8\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT1')\n" +
            "                   THEN\n" +
            "                      10\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT2')\n" +
            "                   THEN\n" +
            "                      11\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT3', 'F', 'F1', 'F3', 'F6')\n" +
            "                   THEN\n" +
            "                      12\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT4')\n" +
            "                   THEN\n" +
            "                      13\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT5', 'MF3')\n" +
            "                   THEN\n" +
            "                      14\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT6')\n" +
            "                   THEN\n" +
            "                      15\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT7')\n" +
            "                   THEN\n" +
            "                      16\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('MT8')\n" +
            "                   THEN\n" +
            "                      17\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('HT1')\n" +
            "                   THEN\n" +
            "                      18\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('HT2')\n" +
            "                   THEN\n" +
            "                      19\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('HT3')\n" +
            "                   THEN\n" +
            "                      20\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('HT4')\n" +
            "                   THEN\n" +
            "                      21\n" +
            "                      WHEN trim(nci.sanction_tariff) IN ('EHT1')\n" +
            "                   THEN\n" +
            "                      22\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('EHT2')\n" +
            "                   THEN\n" +
            "                      23\n" +
            "                   WHEN trim(nci.sanction_tariff) IN ('T')\n" +
            "                   THEN\n" +
            "                      9\n" +
            "                   ELSE\n" +
            "                     1\n" +
            "                END) TARIFF " +
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
    List<ConsumerRow> findByAccountNoSreda(@Param("accountNo") String accountNo);
}