package ftg.djagui.Utilisateur.Metier;

import ftg.djagui.Utilisateur.WebRestController.Dto.DtoRoles;
import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.Model.Roles;

import java.util.List;

public interface MetierRoles {
    Membres addRoleToUser(String role,Membres membres);
    Roles saverole(Roles roles);
    Roles updateRole(Long idrole, DtoRoles dtoRoles);
    boolean desactiveOractive(Long idrole);
    List<Roles> getAllrolle();
    Roles getrolebyname(String role);



}
