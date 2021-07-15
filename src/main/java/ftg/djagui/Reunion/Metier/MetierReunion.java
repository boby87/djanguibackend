package ftg.djagui.Reunion.Metier;

import ftg.djagui.Reunion.Model.Reunion;
import ftg.djagui.Reunion.WebRest.Dto.DtoReunion;
import ftg.djagui.Utilisateur.Dao.DaoMembre;
import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.WebRestController.Dto.DtoMembre;

import java.util.List;

public interface MetierReunion {
    Reunion saveReunion(DtoReunion dtoReunion,Long idpresident);
    Reunion updateReunion(Long idreunion, DtoReunion dtoReunion);
    Reunion getByname(String libelle);
    List<Reunion> getAll();
    Membres addMembreToReunion(DtoMembre dtoMembre, Long idpresident);

}
