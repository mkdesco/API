package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "FEEDERINFO", schema = "XFORMERDB",
        uniqueConstraints = {@UniqueConstraint(name = "UK_FEEDER_NAME", columnNames = {"FEEDER_NAME"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feeder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FeederSeq")
    @SequenceGenerator(name = "FeederSeq", allocationSize = 1, sequenceName = "FEEDERSEQ")
    @Column(name = "FEEDER_ID", nullable = false, updatable = false)
    private Integer feederId;

    @NotEmpty(message = "Feeder Name is mandatory")
    @Column(name = "FEEDER_NAME", nullable = false)
    private String feederName;
}
