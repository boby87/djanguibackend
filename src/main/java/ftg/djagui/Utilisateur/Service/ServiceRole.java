package ftg.djagui.Utilisateur.Service;

import ftg.djagui.CONSTANTE.RoleStatus;
import ftg.djagui.Utilisateur.WebRestController.Dto.DtoRoles;
import ftg.djagui.Utilisateur.Dao.DaoRoles;
import ftg.djagui.Utilisateur.Metier.MetierRoles;
import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.Model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceRole implements MetierRoles {
    @Autowired
    DaoRoles daoRoles;

    @Override
    public Membres addRoleToUser(String role, Membres membres) {
        Roles roles = daoRoles.findByRole(role);
        membres.getRoles().add(roles);
        return membres;
    }

    @Override
    public Roles saverole(Roles roles) {
        return daoRoles.save(roles);
    }

    @Override
    public Roles updateRole(Long idrole, DtoRoles dtoRoles) {
        Roles roles=daoRoles.getById(idrole);
        roles.setRole(dtoRoles.getRole());
        return roles;
    }

    @Override
    public boolean desactiveOractive(Long idrole) {
        Roles roles=daoRoles.getById(idrole);
        roles.setStatuts(!roles.isStatuts());
        return roles.isStatuts();
    }

    @Override
    public List<Roles> getAllrolle() {
        return daoRoles.findAll();
    }

    @Override
    public Roles getrolebyname(String role) {
        return daoRoles.findByRole(role);
    }

   // @Bean
    void ajouterRole() {
        daoRoles.save(new Roles(RoleStatus.ADMIN));
        daoRoles.save(new Roles(RoleStatus.PRESIDENT));
        daoRoles.save(new Roles(RoleStatus.SECRETAIRE));
        daoRoles.save(new Roles(RoleStatus.TRESORIE));
        daoRoles.save(new Roles(RoleStatus.COMMISSAIRE_AU_COMPTE));
        daoRoles.save(new Roles(RoleStatus.SENCEUR));
        daoRoles.save(new Roles(RoleStatus.ADERANT));
    }

}
