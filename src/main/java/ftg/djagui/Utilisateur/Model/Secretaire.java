package ftg.djagui.Utilisateur.Model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idmembre")
public class Secretaire extends Membres{
    public Secretaire() {
    }

    public Secretaire(String nomcomplet, String cni, String sexe, String telephone, String emails, String image, String password) {
        super(nomcomplet, cni, sexe, telephone, emails, image, password);
    }
}
