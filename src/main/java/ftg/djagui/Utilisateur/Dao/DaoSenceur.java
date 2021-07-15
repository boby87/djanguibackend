package ftg.djagui.Utilisateur.Dao;

import ftg.djagui.Utilisateur.Model.Senseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoSenceur extends JpaRepository<Senseur,Long> {
}
