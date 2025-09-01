package desco.ems.service;

import desco.ems.dto.*;
import desco.ems.repository.BillCalculationRepository;
import desco.ems.util.PaymentInformationRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class PaymentService {

    @Autowired
    private BillCalculationRepository billCalculationRepository;

    public PaymentResponseDTO getPaymentInformation(PaymentRequestDTO request) {

        List<ErrorDTO> errors = new ArrayList<>();
        if (!StringUtils.hasText(request.getAccountNumber())) {
            errors.add(new ErrorDTO("400.1", "Consumer Account Number is required."));
        }
        if (!StringUtils.hasText(request.getPaymentStatus())) {
            errors.add(new ErrorDTO("400.2", "Payment Status is required."));
        }
        if (!errors.isEmpty()) {
            return PaymentResponseDTO.builder()
                    .status(400)
                    .data(Collections.emptyList())
                    .errors(errors)
                    .build();
        }

        try {
            List<PaymentInformationRow> rows = billCalculationRepository.findPayments(
                    request.getPaymentStatus(),
                    request.getAccountNumber()
            );

            if (rows.isEmpty()) {
                return PaymentResponseDTO.builder()
                        .status(401)
                        .data(Collections.emptyList())
                        .errors(Collections.singletonList(new ErrorDTO("401.1", "Consumer Number is not valid")))
                        .build();
            }

            List<PaymentDataDTO> data = rows.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());

            return PaymentResponseDTO.builder()
                    .status(200)
                    .data(data)
                    .errors(Collections.emptyList())
                    .build();

        } catch (Exception e) {
            return PaymentResponseDTO.builder()
                    .status(500)
                    .data(Collections.emptyList())
                    .errors(Collections.singletonList(new ErrorDTO("500", e.getMessage())))
                    .build();
        }
    }

    private PaymentDataDTO convertToDto(PaymentInformationRow p) {
        return PaymentDataDTO.builder()
                .accountNumber(p.getAccno())
                .meterNumber(p.getMeter())
                .billNo(p.getBillno())
                .billYear(p.getYear())
                .billMonth(p.getMonth())
                .totalKwh(p.getKwh())
                .totalAmount(p.getTotalamount())
                .totalPaidAmount(p.getPaidamount())
                .paymentDate(p.getCdate())
                .bankCode(p.getBcode())
                .bankName(p.getBank_name())
                .dueDate(p.getDuedate())
                .lpc(p.getLpc())
                .vat(p.getVat())
                .paymentStatus(p.getPaid())
                .issueDate(p.getIssuedate())
                .build();
    }
}
