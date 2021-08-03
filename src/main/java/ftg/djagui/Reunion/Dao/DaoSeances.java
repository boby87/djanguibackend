package ftg.djagui.Reunion.Dao;

import ftg.djagui.Reunion.Model.Seances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DaoSeances extends JpaRepository<Seances,Long> {

    @Query("select s from Seances s where s.reunion.reference=?1")
    List<Seances> findAllSeanceByReferencereunion(String reference);

    @Query("select s from Seances s where s.reunion.reference=?1 and s.statut =: true")
    Seances findSeanceByReferencereunion(String reference);

    Seances findByIdseance(Long idseance);
}
