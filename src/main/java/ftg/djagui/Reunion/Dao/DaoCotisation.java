package ftg.djagui.Reunion.Dao;

import ftg.djagui.Cotisation.Model.Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoCotisation extends JpaRepository<Cotisation,Long> {
}
