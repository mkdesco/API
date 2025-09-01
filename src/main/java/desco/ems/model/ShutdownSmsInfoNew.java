package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SHUTDOWN_SMS_INFO_NEW", schema = "DESCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShutdownSmsInfoNew {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "SND", length = 60)
    private String snd;

    @Column(name = "FEEDER_NAME", length = 150)
    private String feederName;

    @Column(name = "TRANSFORMER_ID", length = 150)
    private String transformerId;

    @Column(name = "ACCOUNT_NO")
    private BigDecimal accountNo;

    @Column(name = "MOBILE_NO", length = 45)
    private String mobileNo;

    @Column(name = "S_N_D_ID")
    private BigDecimal sndId;

}
