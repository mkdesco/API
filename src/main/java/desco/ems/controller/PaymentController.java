package desco.ems.controller;

import desco.ems.dto.*;
import desco.ems.service.PaymentService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(
            path = {"/ssl/api/paymentInformation"},
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<PaymentResponseDTO> getConsumerDetails(
            @Valid @RequestBody PaymentRequestDTO request) {

        PaymentResponseDTO resp = paymentService.getPaymentInformation(request);

        // Guard: avoid IndexOutOfBounds and NPEs
        if (resp == null || resp.getData() == null || resp.getData().isEmpty()) {
            PaymentResponseDTO body = new PaymentResponseDTO();
            body.setStatus(404);
            body.setData(Collections.emptyList());

            if ("1".equals(request.getPaymentStatus())) {
                body.setErrors(Collections.singletonList(new ErrorDTO("404.1", "Consumer has no paid bills.")));
            } else {
                body.setErrors(Collections.singletonList(new ErrorDTO("404.1", "Consumer has no unpaid bills.")));
            }

            return ResponseEntity.status(404)
                    .cacheControl(CacheControl.noStore())
                    .body(body);
        }

        var row = resp.getData().get(0);
        // ETag identifies this representation; include fields that change when data changes
        String etag = "\"" + row.getAccountNumber() + "\"";

        return ResponseEntity.status(resp.getStatus())
                .eTag(etag)
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS).mustRevalidate())
                .body(resp);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<PaymentResponseDTO> badRequest(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        var body = new PaymentResponseDTO();
        body.setStatus(400);
        body.setData(Collections.emptyList());
        body.setErrors(Collections.singletonList(new ErrorDTO("400.1", "Consumer Account Number is required.")));
        return ResponseEntity.badRequest().body(body);
    }
}

