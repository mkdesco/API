package desco.ems.util;

import java.time.LocalDate;

public interface ConsumerRow {
    String getACCOUNTNUMBER();
    String getNAME();
    String getLOAD();
    String getOFFICECODE();
    String getVOLTAGELEVEL();
    String getSITEADDRESS();
    String getMETERNUMBER();
    String getCCATEGORY();
    String getMSTATUS();
    String getFEEDER();
    String getTRANSFORMER();
    LocalDate getINSTALLATIONDATE();
    String getTARIFF();
}
