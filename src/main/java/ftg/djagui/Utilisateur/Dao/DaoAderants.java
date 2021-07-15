package ftg.djagui.Utilisateur.Dao;

import ftg.djagui.Utilisateur.Model.Aderants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoAderants extends JpaRepository<Aderants,Long> {
}
