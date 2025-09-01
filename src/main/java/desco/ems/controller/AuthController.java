package desco.ems.controller;

import desco.ems.dto.*;
import desco.ems.model.BankInformation;
import desco.ems.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/sreda/api/auth/signin")
    public AuthenticationResponseDTO createAuthenticationTokenSREDA (@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        AuthenticationResponseDTO authenticationResponse = authenticationService.authenticate(authenticationRequestDTO);
        return authenticationResponse;
    }

    @PostMapping(value = "/ssl/api/auth/signin")
    public AuthenticationResponseDTO createAuthenticationTokenSSL (@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        AuthenticationResponseDTO authenticationResponse = authenticationService.authenticate(authenticationRequestDTO);
        return authenticationResponse;
    }

    @PostMapping(value = "/gis/api/auth/signin")
    public AuthenticationResponseDTO createAuthenticationTokenGIS (@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        AuthenticationResponseDTO authenticationResponse = authenticationService.authenticate(authenticationRequestDTO);
        return authenticationResponse;
    }
}