package desco.ems.controller;

import desco.ems.dto.*;
import desco.ems.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
public class SredaController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping(
            path = "/sreda/api/consumerinfo",
            consumes = "application/json",
            produces = "application/json")
    public ApiResponse<ConsumerDataSreda> getConsumerDetails(
            @Valid @RequestBody ConsumerRequestDTO request) {

        return consumerService.getByAccountUsingNativeForSreda(request.getAccountNumber());
    }

}
