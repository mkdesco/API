package desco.ems.service;

import desco.ems.dto.*;
import desco.ems.model.BankInformation;
import desco.ems.repository.BankInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private BankInformationRepository bankInformationRepository;

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO authenticationRequestDTO) {
        AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO();

        try {
            if (StringUtils.isEmpty(authenticationRequestDTO.getUsername()) || StringUtils.isEmpty(authenticationRequestDTO.getPassword()) ) {
                authenticationResponseDTO.setStatus(400);
                List<ErrorDTO> errorDTOS = new ArrayList<>();
                if (StringUtils.isEmpty(authenticationRequestDTO.getUsername())) {
                    ErrorDTO errorDTO = new ErrorDTO("400.1", "Username is required.");
                    errorDTOS.add(errorDTO);
                }

                if (StringUtils.isEmpty(authenticationRequestDTO.getPassword())) {
                    ErrorDTO errorDTO = new ErrorDTO("400.1", "Password is required.");
                    errorDTOS.add(errorDTO);
                }

                List<AuthenticationDataDTO> authenticationDataDTOS = new ArrayList<>();
                authenticationResponseDTO.setData(authenticationDataDTOS);

                authenticationResponseDTO.setErrors(errorDTOS);
                return authenticationResponseDTO;
            } else {
                try {
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword())
                    );
                }
                catch (BadCredentialsException e) {
                    authenticationResponseDTO.setStatus(401);
                    List<ErrorDTO> errorDTOS = new ArrayList<>();
                    errorDTOS.add(new ErrorDTO("401.1", "Username or password is invalid"));
                    authenticationResponseDTO.setErrors(errorDTOS);

                    List<AuthenticationDataDTO> authenticationDataDTOS = new ArrayList<>();
                    authenticationResponseDTO.setData(authenticationDataDTOS);

                    return authenticationResponseDTO;
                }

                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(authenticationRequestDTO.getUsername());

                final String jwt = jwtService.generateToken(userDetails);



                List<AuthenticationDataDTO> authenticationDataDTOS = new ArrayList<>();
                AuthenticationDataDTO authenticationDataDTO = new AuthenticationDataDTO(jwt, 360, LocalDateTime.now().toString());
                authenticationDataDTOS.add(authenticationDataDTO);

                authenticationResponseDTO.setStatus(200);
                authenticationResponseDTO.setData(authenticationDataDTOS);

                List<ErrorDTO> errorDTOS = new ArrayList<>();
                authenticationResponseDTO.setErrors(errorDTOS);
                return authenticationResponseDTO;
            }

        } catch (Exception e) {
            authenticationResponseDTO.setStatus(500);

            List<ErrorDTO> errorDTOS = new ArrayList<>();
            errorDTOS.add(new ErrorDTO("500", e.getMessage()));
            authenticationResponseDTO.setErrors(errorDTOS);

            List<AuthenticationDataDTO> authenticationDataDTOS = new ArrayList<>();
            authenticationResponseDTO.setData(authenticationDataDTOS);

            return authenticationResponseDTO;

        }
    }

    public ApiResponse<AuthenticationDataDTO> authenticateForSreda(AuthenticationRequestDTO authenticationRequestDTO) {
        ApiResponse<AuthenticationDataDTO> response = new ApiResponse<>();

        try {
            List<ErrorDTO> errorList = new ArrayList<>();

            if (StringUtils.isEmpty(authenticationRequestDTO.getUsername())) {
                errorList.add(new ErrorDTO("400.1", "Username is required."));
            }

            if (StringUtils.isEmpty(authenticationRequestDTO.getPassword())) {
                errorList.add(new ErrorDTO("400.2", "Password is required."));
            }

            if (!errorList.isEmpty()) {
                response.setStatus(400);
                response.setErrors(errorList);
                response.setData(new AuthenticationDataDTO());
                return response;
            }

            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authenticationRequestDTO.getUsername(),
                                authenticationRequestDTO.getPassword()
                        )
                );
            } catch (BadCredentialsException e) {
                response.setStatus(401);
                response.setErrors(Collections.singletonList(new ErrorDTO("401.1", "Username or password is invalid")));
                response.setData(new AuthenticationDataDTO());
                return response;
            }

            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequestDTO.getUsername());

            final String jwt = jwtService.generateToken(userDetails);

            AuthenticationDataDTO authData = AuthenticationDataDTO.builder()
                    .accessToken(jwt)
                    .expiresIn(360)
                    .createTimeStamp(LocalDateTime.now().toString())
                    .build();

            response.setStatus(200);
            response.setData(authData);
            response.setErrors(new ArrayList<>()); // empty list, will serialize as "Errors": []
            return response;

        } catch (Exception e) {
            response.setStatus(500);
            response.setErrors(Collections.singletonList(new ErrorDTO("500", e.getMessage())));
            response.setData(new AuthenticationDataDTO());
            return response;
        }
    }

    public List<BankInformation> getAllBanks() {
        return bankInformationRepository.findAll();
    }
}
