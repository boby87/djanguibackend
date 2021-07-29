package ftg.djagui.Utilisateur.Dao;

import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.Model.President;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DaoPresident extends JpaRepository<President,Long> {
    @Query("select u from President u where  (lower(u.emails) = :login or u.telephone =: login or (lower(u.cni) = :login)) and u.statut=true")
    President findByUsernameOrEmailOrPhone(String login);

    President findByIdmembre(Long idmembre);
}
