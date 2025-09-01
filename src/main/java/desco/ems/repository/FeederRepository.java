package desco.ems.repository;

import desco.ems.model.Feeder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface FeederRepository extends Repository<Feeder, Integer> {

    @Query(value = "SELECT COUNT(*) FROM XFORMERDB.FEEDERINFO WHERE FEEDER_NAME = :name", nativeQuery = true)
    int countByName(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE XFORMERDB.FEEDERINFO SET FEEDER_NAME = :newName WHERE FEEDER_NAME = :oldName", nativeQuery = true)
    int updateName(@Param("newName") String newName, @Param("oldName") String oldName);
}
