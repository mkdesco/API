package desco.ems.service;

import desco.ems.dto.*;
import desco.ems.repository.NewConsumerInformationRepository;
import desco.ems.util.ConsumerRow;
import desco.ems.util.ConsumerSredaRow;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Service
public class ConsumerService {
    @Autowired
    private NewConsumerInformationRepository consumerInformationRepository;

    @Transactional(readOnly = true)
    @Cacheable(cacheNames="consumerByAccount")
    public ConsumerResponseDTO getByAccountUsingNative(String accountNo) {
        ConsumerResponseDTO resp = new ConsumerResponseDTO();

        LocalDateTime dbStart = LocalDateTime.now();
        var rows = consumerInformationRepository.findByAccountNo(accountNo);
        LocalDateTime dbend = LocalDateTime.now();

        long dbTime = Duration.between(dbStart, dbend).toMillis();
        resp.setDbTime(dbTime);
        System.out.println("Time taken in DB is- " + dbTime);

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

        LocalDateTime operationEnd = LocalDateTime.now();
        long operationTime = Duration.between(dbend, operationEnd).toMillis();
        resp.setOperationTime(operationTime);

        System.out.println("Time taken in operation is- " + operationTime);
        return resp;
    }


    @Transactional(readOnly = true)
    @Cacheable(cacheNames="consumerByAccount")
    public ConsumerResponseDTO getByAccountUsingNativeWithoutJoin(String accountNo) {
        ConsumerResponseDTO resp = new ConsumerResponseDTO();

        LocalDateTime dbStart = LocalDateTime.now();
        var rows = consumerInformationRepository.findByAccountNoWithoutJoin(accountNo);
        LocalDateTime dbend = LocalDateTime.now();

        long dbTime = Duration.between(dbStart, dbend).toMillis();
        resp.setDbTime(dbTime);
        System.out.println("Time taken in DB is- " + dbTime);

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

        LocalDateTime operationEnd = LocalDateTime.now();
        long operationTime = Duration.between(dbend, operationEnd).toMillis();
        resp.setOperationTime(operationTime);

        System.out.println("Time taken in operation is- " + operationTime);
        return resp;
    }

    /*@Transactional(readOnly = true)
    public ConsumerResponseDTO getByAccountUsingJpql(String accountNo) {
        var rows = consumerInformationRepository.findByAccountNoJpql(accountNo);

        ConsumerResponseDTO resp = new ConsumerResponseDTO();
        if (rows == null || rows.isEmpty()) {
            resp.setStatus(401);
            resp.setData(Collections.emptyList());
            resp.setErrors(Collections.singletonList(new ErrorDTO("401.1", "Consumer Number is not valid")));
            return resp;
        }

        // Keep only first row for parity with current behavior
        resp.setStatus(200);
        resp.setData(Collections.singletonList(rows.get(0)));
        resp.setErrors(Collections.emptyList());
        return resp;
    }*/
}
