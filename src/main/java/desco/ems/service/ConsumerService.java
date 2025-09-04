package desco.ems.service;

import desco.ems.dto.*;
import desco.ems.repository.NewConsumerInformationRepository;
import desco.ems.util.ConsumerRow;
import desco.ems.util.ConsumerSredaRow;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@Service
public class ConsumerService {
    @Autowired
    private NewConsumerInformationRepository consumerInformationRepository;

    @Async("dbExecutor")
    @Transactional(readOnly = true)
    public CompletableFuture<ConsumerResponseDTO> getByAccountUsingNative(String accountNo) {

        var rows = consumerInformationRepository.findByAccountNo(accountNo);

        ConsumerResponseDTO resp = new ConsumerResponseDTO();

        if (rows == null || rows.isEmpty()) {
            resp.setStatus(404);
            resp.setData(Collections.emptyList());
            resp.setErrors(Collections.singletonList(new ErrorDTO("404.1", "Consumer not found")));
            return CompletableFuture.completedFuture(resp);
        }

        var row = rows.get(0);
        String date = row.getINSTALLATIONDATE() == null ? null
                : row.getINSTALLATIONDATE().format(DateTimeFormatter.ISO_LOCAL_DATE);

        ConsumerDataDTO dto = new ConsumerDataDTO(
                row.getACCOUNTNUMBER(),
                row.getNAME(),
                row.getMETERNUMBER(),
                row.getLOAD(),
                row.getTARIFF(),
                row.getOFFICECODE(),
                row.getVOLTAGELEVEL(),
                row.getSITEADDRESS(),
                date,
                row.getCCATEGORY(),
                row.getMSTATUS(),
                row.getFEEDER(),
                row.getTRANSFORMER()
        );

        resp.setStatus(200);
        resp.setData(Collections.singletonList(dto));
        resp.setErrors(Collections.emptyList());

        return CompletableFuture.completedFuture(resp);
    }

    public ApiResponse<ConsumerDataSreda> getByAccountUsingNativeForSreda(String accountNo) {
        var rows = consumerInformationRepository.findByAccountNo(accountNo);
        ApiResponse<ConsumerDataSreda> response = new ApiResponse<>();

        if (rows == null || rows.isEmpty()) {
            response.setStatus(404);
            response.setData(new ConsumerDataSreda());
            response.setErrors(Collections.singletonList(new ErrorDTO("404.1", "Consumer not found")));
            return response;
        }

        var row = rows.get(0);

        ConsumerDataSreda dto = ConsumerDataSreda.builder()
                .accountNumber(row.getACCOUNTNUMBER())
                .name(row.getNAME())
                .meterNumber(row.getMETERNUMBER())
                .load(row.getLOAD())
                .tariff(row.getTARIFF())
                .officeCode(row.getOFFICECODE())
                .voltageLevel(row.getVOLTAGELEVEL())
                .siteAddress(row.getSITEADDRESS())
                .build();

        response.setStatus(200);
        response.setData(dto);
        response.setErrors(new ArrayList<>());

        return response;
    }

    @Transactional(readOnly = true)
    @Cacheable(cacheNames="consumerByAccount")
    public ConsumerResponseDTO getByAccountUsingNativeWithoutJoin(String accountNo) {
        ConsumerResponseDTO resp = new ConsumerResponseDTO();

        var rows = consumerInformationRepository.findByAccountNoWithoutJoin(accountNo);

        if (rows == null || rows.isEmpty()) {
            resp.setStatus(401);
            resp.setData(Collections.emptyList());
            resp.setErrors(Collections.singletonList(new ErrorDTO("401.1", "Consumer Number is not valid")));
            return resp;
        }

        // Your current endpoint returns only the first row
        ConsumerRow row = rows.get(0);
        var date = row.getINSTALLATIONDATE() == null ? null
                : row.getINSTALLATIONDATE().format(DateTimeFormatter.ISO_LOCAL_DATE);

        ConsumerDataDTO dto = new ConsumerDataDTO(
                row.getACCOUNTNUMBER(),
                row.getNAME(),
                row.getMETERNUMBER(),
                row.getLOAD(),
                row.getTARIFF(),
                row.getOFFICECODE(),
                row.getVOLTAGELEVEL(),
                row.getSITEADDRESS(),
                date,
                row.getCCATEGORY(),
                row.getMSTATUS(),
                row.getFEEDER(),
                row.getTRANSFORMER()
        );

        resp.setStatus(200);
        resp.setData(Collections.singletonList(dto));
        resp.setErrors(Collections.emptyList());

        return resp;
    }

    /*@Transactional(readOnly = true)
    public ConsumerResponseDTO getByAccountUsingJpql(String accountNo) {
        var rows = consumerInformationRepository.findByAccountNoJpql(accountNo);

        ConsumerResponseDTO resp = new ConsumerResponseDTO();
        if (rows == null || rows.isEmpty()) {
            resp.setStatus(401);
            resp.setData(Collections.emptyList());
            resp.setError(Collections.singletonList(new ErrorDTO("401.1", "Consumer Number is not valid")));
            return resp;
        }

        // Keep only first row for parity with current behavior
        resp.setStatus(200);
        resp.setData(Collections.singletonList(rows.get(0)));
        resp.setError(Collections.emptyList());
        return resp;
    }*/
}
