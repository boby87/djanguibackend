package ftg.djagui.Reunion.Metier;

import ftg.djagui.Reunion.Model.Reunion;
import ftg.djagui.Reunion.Model.Seances;
import ftg.djagui.Reunion.WebRest.Dto.DtoReunion;
import ftg.djagui.Utilisateur.Dao.DaoMembre;
import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.WebRestController.Dto.DtoMembre;

import java.util.List;

public interface MetierReunion {
    Reunion saveReunion(DtoReunion dtoReunion,Long idpresident);
    Reunion updateReunion(Long idreunion, DtoReunion dtoReunion);
    Reunion getByname(String libelle);
    Reunion findreunionByreference(String reference);
    List<Reunion> getAll();
    Membres addMembreToReunion(DtoMembre dtoMembre, Long idpresident);
    String randomString(int len);
    List<Seances> findAllSeanceByReferencereunion(String reference);
    Seances CreateSeance(Seances seances, String referenceReunion);
    Seances findSeanceByReferencereunion(String reference);

    Seances cloturerSeance(Seances seances,Long idSeance);
}
