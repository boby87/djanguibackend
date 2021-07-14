package ftg.lounk.Utilisateur.Model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idmembre")
public class Secretaire extends Membres{
}
