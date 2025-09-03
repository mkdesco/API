package desco.ems.controller;

import desco.ems.dto.ConsumerDataDTO;
import desco.ems.dto.ConsumerRequestDTO;
import desco.ems.dto.ConsumerResponseDTO;
import desco.ems.dto.ErrorDTO;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
public class SredaController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping(
            path = "/sreda/api/consumerInformation",
            consumes = "application/json",
            produces = "application/json")
    public ConsumerDataDTO getConsumerDetails(
            @Valid @RequestBody ConsumerRequestDTO request) {

        return consumerService.getByAccountUsingNativeForSreda(request.getAccountNumber());
    }

}
