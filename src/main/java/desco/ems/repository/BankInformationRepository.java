package desco.ems.repository;

import desco.ems.model.BankInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankInformationRepository extends JpaRepository<BankInformation, String> {
}
