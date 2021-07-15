package ftg.djagui.Reunion.Dao;

import ftg.djagui.Reunion.Model.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoReunion extends JpaRepository<Reunion,Long> {
    Reunion findByLibelleIgnoreCase(String libelle);
}
