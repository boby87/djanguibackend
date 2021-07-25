package ftg.djagui.Tontine.Service;

import ftg.djagui.Tontine.Dao.DaoTontine;
import ftg.djagui.Tontine.Metier.MetierTontine;
import ftg.djagui.Tontine.Model.Tontine;
import ftg.djagui.Reunion.WebRest.Dto.DtoTontine;
import ftg.djagui.Utilisateur.Model.Membres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ServiceTontine implements MetierTontine {
    @Autowired
    DaoTontine daoTontine;

    @Override
    public Membres addTontineMemebre(DtoTontine dtoTontine) {
        return null;
    }

    @Override
    public List<Tontine> geAllTontineActive() {
        return null;
    }
}
