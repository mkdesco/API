package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TRANSFORMERENTITY",  schema = "XFORMERDB")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransformerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TransEntitySeq")
    @SequenceGenerator(name = "TransEntitySeq", allocationSize = 1, sequenceName = "TRANSENTITYSEQ")
    @Column(name = "TRANSFORMER_ID", nullable = false, updatable = false)
    private Integer transId;

    @Column(name="TRANSFORMER_NAME", nullable = false)
    private String transName;

    @Column(name="TRANSFORMER_OLD_NAME")
    private String transOldName;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = NetworkInfo.class)
    @JoinColumn(name = "NETWORK_INFO_ID", nullable = false)
    private NetworkInfo objNetworkInfo;
}
