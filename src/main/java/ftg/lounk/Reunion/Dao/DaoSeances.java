package ftg.lounk.Reunion.Dao;

import ftg.lounk.Reunion.Model.Reunion;
import ftg.lounk.Reunion.Model.Seances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoSeances extends JpaRepository<Seances,Long> {
}
