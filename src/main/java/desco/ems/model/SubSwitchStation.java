package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "SUBSWITCHSTATIONINFO", schema = "XFORMERDB",
        uniqueConstraints = {@UniqueConstraint(name = "UK_SUB_SWITCH_STATION", columnNames = {"SUB_SWITCH_STATION"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubSwitchStation {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SSSeq")
    @SequenceGenerator(name = "SSSeq", allocationSize = 1, sequenceName = "SSSEQ")
    @Column(name = "SS_ID", updatable = false, nullable = false)
    private Integer ssId;

    @NotEmpty(message = "Sub/Switch Station Name is mandatory")
    @Column(name = "SUB_SWITCH_STATION", nullable = false)
    private String ssName;
}
