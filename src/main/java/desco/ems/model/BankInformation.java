package desco.ems.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "BANK_INFORMATION", schema = "DESCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankInformation {

    @Id
    @Column(name = "ROWID", insertable = false, updatable = false)
    private String rowId;

    @Column(name = "BANK_BRANCH", length = 40)
    private String bankBranch;

    @Column(name = "BANK_CODE", length = 8)
    private String bankCode;

    @Column(name = "BANK_NAME", length = 40)
    private String bankName;
}