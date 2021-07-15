package ftg.djagui.Utilisateur.Dao;

import ftg.djagui.Utilisateur.Model.Membres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoMembre extends JpaRepository<Membres,Long> {
    @Query("select u from Membres u where  (lower(u.emails) = :login or u.telephone =: login) and u.statut=true")
    Membres findByUsernameOrEmailOrPhone(String login);
}
