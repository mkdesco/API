package desco.ems.controller;

import desco.ems.dto.*;
import desco.ems.service.GisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@Validated
public class GisController {

    @Autowired
    private GisService gisService;

    @PostMapping("/gis/transformerInfo")
    public ResponseEntity<TransformerDetailsResponseDTO> getDetail(
            @Valid @RequestBody TransformerDetailsRequestDTO request) {
        TransformerDetailsResponseDTO resp = gisService.getTransformerDetails(request);
        return ResponseEntity.status(resp.getStatus()).body(resp);
    }

    @PostMapping("/gis/updateGridName")
    public ResponseEntity<UpdateResponseDTO> updateGrid(@Valid @RequestBody GridUpdateRequestDTO req) {
        UpdateResponseDTO resp = gisService.updateGridName(req.getGridCurrentName(), req.getGridNewName());
        return ResponseEntity.status(resp.getStatus()).body(resp);
    }

    @PostMapping("/gis/updateSSName")
    public ResponseEntity<UpdateResponseDTO> updateSS(@Valid @RequestBody SubSwitchStationUpdateResquestDTO req) {
        UpdateResponseDTO resp = gisService.updateSSName(req.getCurrentSubSwitchStationName(), req.getNewSubSwitchStationName());
        return ResponseEntity.status(resp.getStatus()).body(resp);
    }

    @PostMapping("/gis/updateFeederName")
    public ResponseEntity<UpdateResponseDTO> updateFeeder(@Valid @RequestBody FeederUpdateRequestDTO req) {
        UpdateResponseDTO resp = gisService.updateFeederName(req.getFeederCurrentName(), req.getFeederNewName());
        return ResponseEntity.status(resp.getStatus()).body(resp);
    }
}

