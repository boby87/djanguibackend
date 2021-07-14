package ftg.lounk.Utilisateur.Service;

import ftg.lounk.Utilisateur.Dao.DaoMembre;
import ftg.lounk.Utilisateur.Metier.MetierMembre;
import ftg.lounk.Utilisateur.Model.Membres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceMembre implements MetierMembre {
    @Autowired
    private DaoMembre daoMembre;
    @Override
    public Membres findByUsernameOrEmailOrPhone(String login) {
        return daoMembre.findByUsernameOrEmailOrPhone(login);
    }

    @Override
    public Membres save(Membres membres) {
        membres=daoMembre.save(membres);
        return membres;
    }
}
