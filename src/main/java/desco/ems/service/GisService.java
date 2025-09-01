package desco.ems.service;
import desco.ems.dto.*;
import desco.ems.repository.FeederRepository;
import desco.ems.repository.GridSubstationRepository;
import desco.ems.repository.SubSwitchStationRepository;
import desco.ems.repository.TransInfoRepository;
import desco.ems.util.XformerRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GisService {

    @Autowired
    private TransInfoRepository transInfoRepository;

    @Autowired
    private GridSubstationRepository gridSubstationRepository;

    @Autowired
    private SubSwitchStationRepository subSwitchStationRepository;

    @Autowired
    private FeederRepository feederRepository;

    // ---------- Transformer details ----------

    @Transactional(readOnly = true)
    public TransformerDetailsResponseDTO getTransformerDetails(TransformerDetailsRequestDTO req) {
        List<XformerRow> rows = transInfoRepository.findLatestDetails(
                req.getGridSubStation(),
                req.getSubSwitchStation(),
                req.getFeeder(),
                req.getSndId(),
                req.getTransformerID()
        );

        TransformerDetailsResponseDTO resp = new TransformerDetailsResponseDTO();

        if (rows == null || rows.isEmpty()) {
            resp.setStatus(400);
            resp.setData(Collections.emptyList());
            List<ErrorDTO> errs = new ArrayList<>();
            errs.add(new ErrorDTO("400", "Transformer ID is not valid in the requested network"));
            resp.setErrors(errs);
            return resp;
        }

        XformerRow r = rows.get(0); // one or two rows only

        XformerDetails d = new XformerDetails();
        d.setTransformerID(r.getTID());
        d.setGriSubStation(r.getGRID());
        d.setSubSwitchStation(r.getSS());
        d.setFeeder(r.getFEEDER());
        d.setTotalAmpsR(r.getLOADR());
        d.setTotalAmpsY(r.getLOADY());
        d.setTotalAmpsB(r.getLOADB());
        d.setXfAverageAmps(r.getAVGAMPS());
        d.setMaxAmpsN(r.getLOADN());
        d.setXfMaxAmpsRecordDate(fmtDate(r.getAMPSDATE()));
        d.setLastMaintenanceDate(fmtDate(r.getLAST_MAINTENANCE()));
        d.setNextMaintenanceDate(fmtDate(r.getNEXT_MAINTENANCE()));

        List<XformerDetails> one = new ArrayList<>();
        one.add(d);

        resp.setStatus(200);
        resp.setData(one);
        resp.setErrors(Collections.emptyList());
        return resp;
    }

    private String fmtDate(Timestamp ts) {
        return ts == null ? null : ts.toLocalDateTime().toLocalDate().toString();
    }

    private String asString(Object v) {
        return v == null ? null : String.valueOf(v);
    }

    private String asDateString(Object v) {
        if (v == null) return null;
        if (v instanceof java.sql.Timestamp) {
            return ((java.sql.Timestamp) v).toLocalDateTime().toLocalDate().toString();
        }
        if (v instanceof java.sql.Date) {
            return ((java.sql.Date) v).toLocalDate().toString();
        }
        if (v instanceof java.time.LocalDate) {
            return ((java.time.LocalDate) v).toString();
        }
        if (v instanceof java.time.LocalDateTime) {
            return ((java.time.LocalDateTime) v).toLocalDate().toString();
        }
        return String.valueOf(v);
    }

    // ---------- Updates (native, per-repo) ----------

    @Transactional
    public UpdateResponseDTO updateGridName(String currentName, String newName) {
        int count = gridSubstationRepository.countByName(currentName);
        if (count < 1) return error(400, "400.1", "Grid Substation is not Present in Transformer DB");
        int updated = gridSubstationRepository.updateName(newName, currentName);
        return updated > 0 ? success() : error(400, "400.2", "Grid Substation Update Failed");
    }

    @Transactional
    public UpdateResponseDTO updateSSName(String currentName, String newName) {
        int count = subSwitchStationRepository.countByName(currentName);
        if (count < 1) return error(400, "400.1", "Sub Switch Station is not Present in Transformer DB");
        int updated = subSwitchStationRepository.updateName(newName, currentName);
        return updated > 0 ? success() : error(400, "400.2", "Sub Switch Station Update Failed");
    }

    @Transactional
    public UpdateResponseDTO updateFeederName(String currentName, String newName) {
        int count = feederRepository.countByName(currentName);
        if (count < 1) return error(400, "400.1", "Feeder is not Present in Transformer DB");
        int updated = feederRepository.updateName(newName, currentName);
        return updated > 0 ? success() : error(400, "400.2", "Feeder Update Failed");
    }

    private UpdateResponseDTO success() {
        UpdateResponseDTO r = new UpdateResponseDTO();
        r.setStatus(200);
        r.setUpdated(true);
        r.setErrors(Collections.emptyList());
        return r;
    }

    private UpdateResponseDTO error(int status, String code, String msg) {
        UpdateResponseDTO r = new UpdateResponseDTO();
        r.setStatus(status);
        r.setUpdated(false);
        List<ErrorDTO> errs = new ArrayList<>();
        errs.add(new ErrorDTO(code, msg));
        r.setErrors(errs);
        return r;
    }
}
