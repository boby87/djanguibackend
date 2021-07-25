package ftg.djagui.Sentions.Model;

import ftg.djagui.Tontine.Model.Tontine;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EnregistrerSentions {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenregistrementsention;
    private Date datetsention;
    @ManyToOne
    @JoinColumn(name = "idmembre")
    private Membres membres;
    @ManyToOne
    @JoinColumn(name = "idsention")
    private Sention sention;

}
