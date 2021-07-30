package ftg.djagui.Reunion.Service;

import ftg.djagui.Reunion.Dao.DaoReunion;
import ftg.djagui.Reunion.Metier.MetierReunion;
import ftg.djagui.Reunion.Model.Reunion;
import ftg.djagui.Reunion.WebRest.Dto.DtoReunion;
import ftg.djagui.Utilisateur.Dao.DaoPresident;
import ftg.djagui.Utilisateur.Metier.MetierMembre;
import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.Model.President;
import ftg.djagui.Utilisateur.WebRestController.Dto.DtoMembre;
import ftg.djagui.configuration.ErrorMessage.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;

@Service
@Transactional
public class ServiceReunion implements MetierReunion {
    @Autowired
    DaoReunion daoReunion;
    @Autowired
    DaoPresident daoPresident;
    @Autowired
    MetierMembre metierMembre;

    static SecureRandom rnd = new SecureRandom();
    @Override
    public Reunion saveReunion(DtoReunion dtoReunion, Long idpresident) {
        President president=daoPresident.findByIdmembre(idpresident);
        if (president==null) throw new ErrorMessages("Vous n'etes pas autorisé à créer une reunion", HttpStatus.UNAUTHORIZED);
        if (daoReunion.findByLibelleIgnoreCase(dtoReunion.getLibelle())!=null)throw new ErrorMessages("Bien vouloir changer le nom de la reunion", HttpStatus.UNAUTHORIZED);
        Reunion reunion=new Reunion();
        BeanUtils.copyProperties(dtoReunion,reunion);
        reunion.setCreateur(president.getUsername());
        reunion.setReference(randomString(8));
        reunion=daoReunion.save(reunion);
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
    public Reunion findreunionByreference(String reference) {
        return daoReunion.findByReference(reference);
    }

    @Override
    public List<Reunion> getAll() {
        return daoReunion.findAll();
    }

    @Override
    public Membres addMembreToReunion(DtoMembre dtoMembre, Long idpresident) {
        President president=daoPresident.getById(idpresident);
        Membres membres=metierMembre.save(dtoMembre);
        membres.setReunion(president.getReunion());
        return membres;
    }

    @Override
    public String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        System.out.println("*************************" + sb.toString());
        return sb.toString();
    }
}
