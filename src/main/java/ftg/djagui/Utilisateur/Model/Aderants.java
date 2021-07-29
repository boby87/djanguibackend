package ftg.djagui.Utilisateur.Model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idmembre")
public class Aderants extends Membres{

}
