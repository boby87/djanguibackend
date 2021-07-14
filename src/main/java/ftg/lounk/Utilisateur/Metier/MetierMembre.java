package ftg.lounk.Utilisateur.Metier;

import ftg.lounk.Utilisateur.Model.Membres;

public interface MetierMembre {
    Membres findByUsernameOrEmailOrPhone(String login);
    Membres save(Membres membres);
}
