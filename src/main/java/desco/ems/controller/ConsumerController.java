package desco.ems.controller;

import desco.ems.dto.ConsumerRequestDTO;
import desco.ems.dto.ConsumerResponseDTO;
import desco.ems.dto.ErrorDTO;
import desco.ems.service.ConsumerService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping(
            path = "/ssl/api/consumerInformation",
            consumes = "application/json",
            produces = "application/json")
    public CompletableFuture<ResponseEntity<ConsumerResponseDTO>> getConsumerDetails(
            @Valid @RequestBody ConsumerRequestDTO request) {

        return consumerService.getByAccountUsingNative(request.getAccountNumber())
                .thenApply(resp -> {
                    if (resp == null || resp.getData() == null || resp.getData().isEmpty()) {
                        ConsumerResponseDTO body = new ConsumerResponseDTO();
                        body.setStatus(404);
                        body.setData(Collections.emptyList());
                        body.setErrors(Collections.singletonList(new ErrorDTO("404.1", "Consumer not found")));
                        return ResponseEntity.status(404)
                                .cacheControl(CacheControl.noStore())
                                .body(body);
                    }

                    return ResponseEntity.status(resp.getStatus())
                            .cacheControl(CacheControl.noStore())
                            .body(resp);
                });
    }

    @PostMapping(
            path = {"/ssl/api/consumerInformationWithoutJoin"},
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<ConsumerResponseDTO> getConsumerDetailsWithoutJoin(
            @Valid @RequestBody ConsumerRequestDTO request) {
        LocalDateTime callStart = LocalDateTime.now();


        ConsumerResponseDTO resp = consumerService.getByAccountUsingNativeWithoutJoin(request.getAccountNumber());

        // Guard: avoid IndexOutOfBounds and NPEs
        if (resp == null || resp.getData() == null || resp.getData().isEmpty()) {
            ConsumerResponseDTO body = new ConsumerResponseDTO();
            body.setStatus(404);
            body.setData(Collections.emptyList());
            body.setErrors(Collections.singletonList(new ErrorDTO("404.1", "Consumer not found")));
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
    public ResponseEntity<ConsumerResponseDTO> badRequest(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        var body = new ConsumerResponseDTO();
        body.setStatus(400);
        body.setData(Collections.emptyList());
        body.setErrors(Collections.singletonList(new ErrorDTO("400.1", "Consumer Account Number is required.")));
        return ResponseEntity.badRequest().body(body);
    }
}
