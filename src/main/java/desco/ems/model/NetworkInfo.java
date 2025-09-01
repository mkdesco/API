package desco.ems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NETWORKINFO", schema = "XFORMERDB")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NetworkInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NetworkSeq")
    @SequenceGenerator(name = "NetworkSeq", allocationSize = 1, sequenceName = "NETWORKSEQ")
    @Column(name = "NETWORK_INFO_ID", nullable = false, updatable = false)
    private Integer networkInfoId;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesAndDistribution.class)
    @JoinColumn(name = "S_N_D_ID", nullable = false)
    @NotNull(message = "Select a valid S&D")
    private SalesAndDistribution objSnd;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GridSubstation.class)
    @JoinColumn(name = "GRID_SS_ID", nullable = false)
    @NotNull(message = "Select a valid Grid Sub Station")
    private GridSubstation objGridSS;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SubSwitchStation.class)
    @JoinColumn(name = "SS_ID", nullable = false)
    @NotNull(message = "Select a valid Sub/Switch Station")
    private SubSwitchStation objSS;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Feeder.class)
    @JoinColumn(name = "FEEDER_ID", nullable = false)
    @NotNull(message = "Select a valid Feeder")
    private Feeder objFeeder;
}
