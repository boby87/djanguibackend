package ftg.djagui.Tontine.Metier;

import ftg.djagui.Reunion.WebRest.Dto.DtoTontine;
import ftg.djagui.Tontine.Model.Tontine;
import ftg.djagui.Utilisateur.Model.Membres;

import java.util.List;

public interface MetierTontine {
     Membres addTontineMemebre(DtoTontine dtoTontine);
     List<Tontine> geAllTontineActive();
}
