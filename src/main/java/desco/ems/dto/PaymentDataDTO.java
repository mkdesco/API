package desco.ems.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PaymentDataDTO {
    private String accountNumber;
    private String meterNumber;
    private String billNo;
    private String billMonth;
    private String billYear;
    private String totalKwh;
    private String totalAmount;
    private String lpc;
    private String vat;
    private String issueDate;
    private String dueDate;
    private String paymentStatus;
    private String totalPaidAmount;
    private String paymentDate;
    private String bankCode;
    private String bankName;
}
