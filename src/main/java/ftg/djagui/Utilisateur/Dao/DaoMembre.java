package ftg.djagui.Utilisateur.Dao;

import ftg.djagui.Utilisateur.Model.Membres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DaoMembre extends JpaRepository<Membres,Long> {
    @Query("select u from Membres u where  (lower(u.username) = :x) and u.statut=true")
    Membres findByUsernameOrEmailOrPhone(@Param("x") String login);
}
