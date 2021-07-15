package ftg.djagui.Reunion.Service;

import ftg.djagui.Reunion.Dao.DaoReunion;
import ftg.djagui.Reunion.Metier.MetierReunion;
import ftg.djagui.Reunion.Model.Reunion;
import ftg.djagui.Reunion.WebRest.Dto.DtoReunion;
import ftg.djagui.Utilisateur.Dao.DaoPresident;
import ftg.djagui.Utilisateur.Model.President;
import ftg.djagui.configuration.ErrorMessage.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceReunion implements MetierReunion {
    @Autowired
    DaoReunion daoReunion;
    @Autowired
    DaoPresident daoPresident;
    @Override
    public Reunion saveReunion(DtoReunion dtoReunion, Long idpresident) {
        President president=daoPresident.getById(idpresident);
        if (president==null) throw new ErrorMessages("Vous n'etes pas autorisé à créer une reunion", HttpStatus.UNAUTHORIZED);
        Reunion reunion=daoReunion.save(new Reunion(dtoReunion.getLibelle(),dtoReunion.getTelephone(), dtoReunion.getEmail(), dtoReunion.getLogo()));
        president.setReunion(reunion);
        return reunion;
    }

    @Override
    public Reunion updateReunion(Long idreunion, DtoReunion dtoReunion) {
        Reunion reunion=daoReunion.getById(idreunion);
        BeanUtils.copyProperties(dtoReunion ,reunion);
        return reunion;
    }

    @Override
    public Reunion getByname(String libelle) {
        return daoReunion.findByLibelleIgnoreCase(libelle);
    }

    @Override
    public List<Reunion> getAll() {
        return daoReunion.findAll();
    }
}
