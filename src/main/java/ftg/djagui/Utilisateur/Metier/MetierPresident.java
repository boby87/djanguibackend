package ftg.djagui.Utilisateur.Metier;

import ftg.djagui.Utilisateur.Model.President;

import java.util.List;

public interface MetierPresident {
    President getPresidentById(Long idpresident);
    President getPresidentBylogin(String login);
    List<President> getAllPresident();


}
