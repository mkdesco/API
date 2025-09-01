package desco.ems.repository;

import desco.ems.model.GridSubstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GridSubstationRepository extends JpaRepository<GridSubstation, Integer> {

    @Query(value = "SELECT COUNT(*) FROM XFORMERDB.GRIDSUBSTATIONINFO WHERE GRID_SUBSTATION = :name", nativeQuery = true)
    int countByName(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE XFORMERDB.GRIDSUBSTATIONINFO SET GRID_SUBSTATION = :newName WHERE GRID_SUBSTATION = :oldName", nativeQuery = true)
    int updateName(@Param("newName") String newName, @Param("oldName") String oldName);
}

