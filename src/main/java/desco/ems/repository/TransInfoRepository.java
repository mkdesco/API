package desco.ems.repository;

import desco.ems.model.TransInfo;
import desco.ems.util.XformerRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransInfoRepository extends JpaRepository<TransInfo, Integer> {

    @Query(value = ""
            + "SELECT "
            + "  TE.TRANSFORMER_NAME AS TID, "
            + "  GI.GRID_SUBSTATION   AS GRID, "
            + "  SI.SUB_SWITCH_STATION AS SS, "
            + "  FI.FEEDER_NAME       AS FEEDER, "
            + "  TI.TOTAL_LOAD_R      AS LOADR, "
            + "  TI.TOTAL_LOAD_Y      AS LOADY, "
            + "  TI.TOTAL_LOAD_B      AS LOADB, "
            + "  TI.AVG_AMPS_OF_XF    AS AVGAMPS, "
            + "  TI.MAX_LOAD_N        AS LOADN, "
            + "  TI.XF_AMPS_DATE      AS AMPSDATE, "
            + "  TI.LAST_MAINTENANCE  AS LAST_MAINTENANCE, "
            + "  TI.PROPOSED_M_DATE   AS NEXT_MAINTENANCE "
            + "FROM XFORMERDB.TRANSINFO TI "
            + "JOIN XFORMERDB.TRANSFORMERENTITY TE ON TI.TRANSFORMER_ID = TE.TRANSFORMER_ID "
            + "JOIN XFORMERDB.NETWORKINFO NI ON NI.NETWORK_INFO_ID = TE.NETWORK_INFO_ID "
            + "JOIN XFORMERDB.GRIDSUBSTATIONINFO GI ON GI.GRID_SS_ID = NI.GRID_SS_ID "
            + "JOIN XFORMERDB.SUBSWITCHSTATIONINFO SI ON SI.SS_ID = NI.SS_ID "
            + "JOIN XFORMERDB.FEEDERINFO FI ON FI.FEEDER_ID = NI.FEEDER_ID "
            + "JOIN XFORMERDB.SALESANDDISTRIBUTION SND ON SND.S_N_D_ID = NI.S_N_D_ID "
            + "JOIN ( "
            + "  SELECT TI1.TRANSFORMER_ID, MAX(TI1.TRANSFORMER_INFO_ID) AS MAX_ID "
            + "  FROM XFORMERDB.TRANSINFO TI1 "
            + "  GROUP BY TI1.TRANSFORMER_ID "
            + ") LTI ON TI.TRANSFORMER_INFO_ID = LTI.MAX_ID "
            + "WHERE (TE.TRANSFORMER_OLD_NAME IS NULL OR TE.TRANSFORMER_NAME <> TE.TRANSFORMER_OLD_NAME) "
            + "  AND GI.GRID_SUBSTATION = :grid "
            + "  AND SI.SUB_SWITCH_STATION = :ss "
            + "  AND FI.FEEDER_NAME = :feeder "
            + "  AND SND.S_N_D_ID = :sndId "
            + "  AND TE.TRANSFORMER_NAME = :xfName",
            nativeQuery = true)
    List<XformerRow> findLatestDetails(
            @Param("grid") String grid,
            @Param("ss") String ss,
            @Param("feeder") String feeder,
            @Param("sndId") Integer sndId,
            @Param("xfName") String transformerName
    );
}

