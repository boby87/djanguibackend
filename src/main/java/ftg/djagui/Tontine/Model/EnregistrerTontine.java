package ftg.djagui.Tontine.Model;

import ftg.djagui.Tontine.Dao.DaoTontine;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EnregistrerTontine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenregistrementtontine;
    private Date datetontine;
    @ManyToOne
    @JoinColumn(name = "idmembre")
    private Membres membres;
    @ManyToOne
    @JoinColumn(name = "idtontine")
    private Tontine tontine;

    public Long getIdenregistrementtontine() {
        return idenregistrementtontine;
    }

    public void setIdenregistrementtontine(Long idenregistrementtontine) {
        this.idenregistrementtontine = idenregistrementtontine;
    }

    public Date getDatetontine() {
        return datetontine;
    }

    public void setDatetontine(Date datetontine) {
        this.datetontine = datetontine;
    }

    public Membres getMembres() {
        return membres;
    }

    public void setMembres(Membres membres) {
        this.membres = membres;
    }

    public Tontine getTontine() {
        return tontine;
    }

    public void setTontine(Tontine tontine) {
        this.tontine = tontine;
    }
}
