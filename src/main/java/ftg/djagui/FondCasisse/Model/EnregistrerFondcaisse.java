package ftg.djagui.FondCasisse.Model;

import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EnregistrerFondcaisse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenregistrementfond;
    private Date datefondcaisse;
    @ManyToOne
    @JoinColumn(name = "idmembre")
    private Membres membres;
    @ManyToOne
    @JoinColumn(name = "idtontine")
    private FondCaisse fondCaisse;

    public Long getIdenregistrementfond() {
        return idenregistrementfond;
    }

    public void setIdenregistrementfond(Long idenregistrementfond) {
        this.idenregistrementfond = idenregistrementfond;
    }

    public Date getDatefondcaisse() {
        return datefondcaisse;
    }

    public void setDatefondcaisse(Date datefondcaisse) {
        this.datefondcaisse = datefondcaisse;
    }

    public Membres getMembres() {
        return membres;
    }

    public void setMembres(Membres membres) {
        this.membres = membres;
    }

    public FondCaisse getFondCaisse() {
        return fondCaisse;
    }

    public void setFondCaisse(FondCaisse fondCaisse) {
        this.fondCaisse = fondCaisse;
    }
}
