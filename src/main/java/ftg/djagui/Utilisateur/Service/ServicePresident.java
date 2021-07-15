package ftg.djagui.Utilisateur.Service;

import ftg.djagui.Utilisateur.Dao.DaoPresident;
import ftg.djagui.Utilisateur.Metier.MetierPresident;
import ftg.djagui.Utilisateur.Model.President;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicePresident implements MetierPresident {
    @Autowired
    DaoPresident daoPresident;


    @Override
    public President getPresidentById(Long idpresident) {
        return daoPresident.getById(idpresident);
    }

    @Override
    public President getPresidentBylogin(String login) {
        return daoPresident.findByUsernameOrEmailOrPhone(login);
    }

    @Override
    public List<President> getAllPresident() {
        return daoPresident.findAll();
    }
}
