package desco.ems.util;

import java.sql.Timestamp;

public interface XformerRow {
    String getTID();
    String getGRID();
    String getSS();
    String getFEEDER();
    String getLOADR();
    String getLOADY();
    String getLOADB();
    String getAVGAMPS();
    String getLOADN();
    String getAMPSDATE();
    String getLAST_MAINTENANCE();
    String getNEXT_MAINTENANCE();
}
