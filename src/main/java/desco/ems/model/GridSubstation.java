package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "GRIDSUBSTATIONINFO", schema = "XFORMERDB",
        uniqueConstraints = {@UniqueConstraint(name = "UK_GRID_SUBSTATION", columnNames = {"GRID_SUBSTATION"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GridSubstation {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GridSeq")
    @SequenceGenerator(name = "GridSeq", allocationSize = 1, sequenceName = "GRIDSEQ")
    @Column(name = "GRID_SS_ID", updatable = false, nullable = false)
    private Integer gridSSId;

    @NotEmpty(message = "Grid Sub-Station Name is mandatory")
    @Column(name = "GRID_SUBSTATION", nullable = false)
    private String gridSSName;
}
