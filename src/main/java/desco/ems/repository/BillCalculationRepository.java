package desco.ems.repository;


import desco.ems.model.BillCalculation;
import desco.ems.util.PaymentInformationRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillCalculationRepository extends JpaRepository<BillCalculation, String> {

    @Query(value =
            "SELECT " +
                    "    BC.ACCOUNT_NO        AS ACCNO, " +
                    "    BC.METER_NO          AS METER, " +
                    "    BC.BILL_NO           AS BILLNO, " +
                    "    TO_CHAR(BC.YEAR)     AS YEAR, " +
                    "    LPAD(TO_CHAR(BC.MONTH),2,'0') AS MONTH, " +
                    "    TO_CHAR(BC.TOTAL_KWH)         AS KWH, " +
                    "    TO_CHAR(BC.TOTAL_AMOUNT)      AS TOTALAMOUNT, " +
                    "    TO_CHAR(BC.TOTAL_PAID_AMOUNT) AS PAIDAMOUNT, " +
                    "    TO_CHAR(BC.COLLECTION_DATE, 'YYYY-MM-DD') AS CDATE, " +
                    "    BCO.BANK_CODE        AS BCODE, " +
                    "    BI.BANK_NAME         AS BANK_NAME, " +
                    "    TO_CHAR(BC.DUE_DATE, 'YYYY-MM-DD')   AS DUEDATE, " +
                    "    TO_CHAR(BC.LPC)       AS LPC, " +
                    "    TO_CHAR(BC.VAT_TOTAL) AS VAT, " +
                    "    BC.PAID               AS PAID, " +
                    "    TO_CHAR(BC.ISSUE_DATE, 'YYYY-MM-DD') AS ISSUEDATE " +
                    "FROM DESCO.BILL_CALCULATION BC " +
                    "LEFT JOIN DESCO.BILL_COLLECTION BCO ON BC.BILL_NO = BCO.BILL_NO " +
                    "LEFT JOIN DESCO.BANK_INFORMATION BI ON BI.BANK_CODE = BCO.BANK_CODE " +
                    "WHERE BC.PAID = :paid " +
                    "  AND BC.ACCOUNT_NO = :accountNo " +
                    "ORDER BY BC.YEAR DESC, BC.MONTH DESC ",
            nativeQuery = true)
    List<PaymentInformationRow> findPayments(
            @Param("paid") String paid,
            @Param("accountNo") String accountNo
    );
}