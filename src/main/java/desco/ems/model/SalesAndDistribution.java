package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SALESANDDISTRIBUTION", schema = "XFORMERDB",
        uniqueConstraints = {@UniqueConstraint(name = "UK_S_N_D_NAME", columnNames = {"S_N_D_NAME"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesAndDistribution {

    @Id
    @Column(name = "S_N_D_ID", nullable = false, updatable = false)
    private Integer sndId;

    @Column(name = "S_N_D_NAME", nullable = false, updatable = false)
    private String sndName;
}
