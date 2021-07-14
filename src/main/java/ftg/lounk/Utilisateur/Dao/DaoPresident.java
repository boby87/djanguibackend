package ftg.lounk.Utilisateur.Dao;

import ftg.lounk.Utilisateur.Model.President;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoPresident extends JpaRepository<President,Long> {
}
