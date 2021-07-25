package ftg.djagui.Utilisateur.Service;

import ftg.djagui.CONSTANTE.RoleStatus;
import ftg.djagui.Utilisateur.WebRestController.Dto.DtoMembre;
import ftg.djagui.Utilisateur.Dao.*;
import ftg.djagui.Utilisateur.Metier.MetierMembre;
import ftg.djagui.Utilisateur.Metier.MetierRoles;
import ftg.djagui.Utilisateur.Model.*;
import ftg.djagui.configuration.ErrorMessage.ErrorMessages;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ServiceMembre implements MetierMembre {
    @Autowired
    private DaoMembre daoMembre;
    @Autowired
    private MetierRoles metierRoles;
    @Autowired
    DaoRoles daoRoles;
    @Autowired
    DaoAderants daoAderants;
    @Autowired
    DaoPresident daoPresident;
    @Autowired
    DaoSecretaire daoSecretaire;
    @Autowired
    DaoTresorie daoTresorie;
    @Autowired
    DaoCommissairecompte daoCommissairecompte;
    @Autowired
    DaoSenceur daoSenceur;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Membres findByUsernameOrEmailOrPhone(String login) {
        return daoMembre.findByUsernameOrEmailOrPhone(login);
    }

    @Override
    public Membres save(DtoMembre dtoMembre) {
        String hashpw = bCryptPasswordEncoder.encode(dtoMembre.getPassword());
        Roles roles = daoRoles.findByRole(dtoMembre.getRole());
        if (roles == null) throw new ErrorMessages("merci de choisir un role qui existe", HttpStatus.NO_CONTENT);
        Membres membres=findByUsernameOrEmailOrPhone(dtoMembre.getUsername());
        if (membres!=null)throw new ErrorMessages("Le username est deja utiliser",HttpStatus.CONFLICT);
        if (roles.getRole().equals(RoleStatus.PRESIDENT)){
            President president=new President();
            BeanUtils.copyProperties(dtoMembre,president);
            president.setPassword(hashpw);
            membres=daoPresident.save(president);
            membres= metierRoles.addRoleToUser(roles.getRole(),membres);

        }else if (roles.getRole().equals(RoleStatus.SECRETAIRE)){
            Secretaire secretaire=new Secretaire();
            BeanUtils.copyProperties(dtoMembre,secretaire);
            secretaire.setPassword(hashpw);
            membres=daoSecretaire.save(secretaire);
        }else if (roles.getRole().equals(RoleStatus.TRESORIE)){
            Tresorie tresorie=new Tresorie();
            BeanUtils.copyProperties(dtoMembre,tresorie);
            tresorie.setPassword(hashpw);
            membres=daoTresorie.save(tresorie);
        }else if (roles.getRole().equals(RoleStatus.COMMISSAIRE_AU_COMPTE)){
            Commissairecompte commissairecompte=new Commissairecompte();
            BeanUtils.copyProperties(dtoMembre,commissairecompte);
            commissairecompte.setPassword(hashpw);
            membres=daoCommissairecompte.save(commissairecompte);
        }else if (roles.getRole().equals(RoleStatus.SENCEUR)){
            Senseur senseur=new Senseur();
            BeanUtils.copyProperties(dtoMembre,senseur);
            senseur.setPassword(hashpw);
            membres=daoSenceur.save(senseur);
        }else {
            Aderants aderants=new Aderants();
            BeanUtils.copyProperties(dtoMembre,aderants);
            aderants.setPassword(hashpw);
            membres=daoAderants.save(aderants);
        }
        membres.getRoles().add(roles);
        membres= metierRoles.addRoleToUser(RoleStatus.ADERANT,membres);
        return membres;
    }

    @Override
    public Membres update(DtoMembre dtoMembre, Long idmembre) {
        Membres membres = daoMembre.getById(idmembre);
        BeanUtils.copyProperties(dtoMembre, membres);
        return membres;
    }

    @Override
    public Membres changeRoleMembre(String newRole, Long iduser) {
        Membres membres=daoMembre.getById(iduser);
        Roles new_roles=daoRoles.findByRole(newRole);
        Roles roles1=daoRoles.findByRole(RoleStatus.ADERANT);
        Set<Roles> rolesList=new HashSet<>();
        rolesList.add(roles1);
        rolesList.add(new_roles);
        membres.setRoles(null);
        membres.setRoles(rolesList);

        return membres;
    }

    @Override
    public List<Membres> getAllmembre() {
        return daoMembre.findAll();
    }
}
