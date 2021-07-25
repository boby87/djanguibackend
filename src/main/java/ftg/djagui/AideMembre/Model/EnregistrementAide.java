package ftg.djagui.AideMembre.Model;

import ftg.djagui.FondCasisse.Model.FondCaisse;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;
@Entity
public class EnregistrementAide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenregistrementaide;
    private Date dateaide;
    @ManyToOne
    @JoinColumn(name = "idmembre")
    private Membres membres;
    @ManyToOne
    @JoinColumn(name = "idaide")
    private Aide aide;

    public Long getIdenregistrementaide() {
        return idenregistrementaide;
    }

    public void setIdenregistrementaide(Long idenregistrementaide) {
        this.idenregistrementaide = idenregistrementaide;
    }

    public Date getDateaide() {
        return dateaide;
    }

    public void setDateaide(Date dateaide) {
        this.dateaide = dateaide;
    }

    public Membres getMembres() {
        return membres;
    }

    public void setMembres(Membres membres) {
        this.membres = membres;
    }

    public Aide getAide() {
        return aide;
    }

    public void setAide(Aide aide) {
        this.aide = aide;
    }
}
