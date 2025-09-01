package desco.ems.repository;

import desco.ems.model.SubSwitchStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubSwitchStationRepository extends JpaRepository<SubSwitchStation, Integer> {

    @Query(value = "SELECT COUNT(*) FROM XFORMERDB.SUBSWITCHSTATIONINFO WHERE SUB_SWITCH_STATION = :name", nativeQuery = true)
    int countByName(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE XFORMERDB.SUBSWITCHSTATIONINFO SET SUB_SWITCH_STATION = :newName WHERE SUB_SWITCH_STATION = :oldName", nativeQuery = true)
    int updateName(@Param("newName") String newName, @Param("oldName") String oldName);
}
