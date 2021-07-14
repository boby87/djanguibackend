package ftg.lounk.Reunion.Dao;

import ftg.lounk.Reunion.Model.Reunion;
import ftg.lounk.Reunion.Model.Sention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoSentions extends JpaRepository<Sention,Long> {
}
