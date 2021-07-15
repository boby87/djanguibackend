package ftg.djagui.Utilisateur.Metier;

import ftg.djagui.Utilisateur.WebRestController.Dto.DtoMembre;
import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.Model.Roles;

import java.util.List;

public interface MetierMembre {
    Membres findByUsernameOrEmailOrPhone(String login);
    Membres save(DtoMembre dtoMembre);
    Membres update(DtoMembre dtoMembre,Long idmembre);
    Membres changeRoleMembre(String newRole, Long iduser);
    List<Membres> getAllmembre();
}
