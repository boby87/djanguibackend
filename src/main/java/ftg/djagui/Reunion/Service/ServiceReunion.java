package ftg.djagui.Reunion.Service;

import ftg.djagui.Reunion.Dao.DaoReunion;
import ftg.djagui.Reunion.Dao.DaoSeances;
import ftg.djagui.Reunion.Metier.MetierReunion;
import ftg.djagui.Reunion.Model.Reunion;
import ftg.djagui.Reunion.Model.Seances;
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
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ServiceReunion implements MetierReunion {
    @Autowired
    DaoReunion daoReunion;
    @Autowired
    DaoSeances daoSeances;
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

    @Override
    public List<Seances> findAllSeanceByReferencereunion(String reference) {

        return daoSeances.findAllSeanceByReferencereunion(reference);
    }

    @Override
    public Seances CreateSeance(Seances seances, String referenceReunion) {
        Seances seances1=findSeanceByReferencereunion(referenceReunion);
        if (seances1!=null)throw new ErrorMessages("Bien vouloir fermer la seance du "+seances1.getLibelle(),HttpStatus.CONFLICT);
        seances.setDate(new Date());
        seances.setStatut(true);
        return daoSeances.save(seances);
    }

    @Override
    public Seances findSeanceByReferencereunion(String reference) {
        return daoSeances.findSeanceByReferencereunion(reference);
    }

    @Override
    public Seances cloturerSeance(Seances seances, Long idSeance) {
        Seances seances1=daoSeances.findByIdseance(idSeance);
        seances1.setStatut(false);
        seances1.setOrdredujour(seances.getOrdredujour());
        seances1.setRapport(seances.getRapport());
        return seances1;
    }
}
