package ftg.djagui.Reunion.Model;

import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tontine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtontine;
    private Date jourtontine;
    private Date date;
    private double montant;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "idmembre")
    private Membres membres;

    public Long getIdtontine() {
        return idtontine;
    }

    public void setIdtontine(Long idtontine) {
        this.idtontine = idtontine;
    }

    public Date getJourtontine() {
        return jourtontine;
    }

    public void setJourtontine(Date jourtontine) {
        this.jourtontine = jourtontine;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Membres getMembres() {
        return membres;
    }

    public void setMembres(Membres membres) {
        this.membres = membres;
    }
}
