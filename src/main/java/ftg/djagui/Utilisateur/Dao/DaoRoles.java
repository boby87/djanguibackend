package ftg.djagui.Utilisateur.Dao;

import ftg.djagui.Utilisateur.Model.Roles;
import ftg.djagui.Utilisateur.Model.Tresorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoRoles extends JpaRepository<Roles,Long> {

    Roles findByRole(String role);
}
