package ftg.djagui.Reunion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ftg.djagui.AideMembre.Model.Aide;
import ftg.djagui.Cotisation.Model.Cotisation;
import ftg.djagui.FondCasisse.Model.FondCaisse;
import ftg.djagui.Sentions.Model.Sention;
import ftg.djagui.Tontine.Model.Tontine;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Seances {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idseance;
    private Date date;
    private String libelle;//les differentes date de la reunion
    private Date jourreunion;
    private Date jourtontine;
    private String ordredujour;
    private String rapport;
    private boolean statut;
    @OneToOne
    @JoinColumn(name = "idcotisation")
    private Cotisation cotisation;
    @OneToOne
    @JoinColumn(name = "idsention")
    private Sention sention;
    @OneToOne
    @JoinColumn(name = "idtontine")
    private Tontine tontine;
    @OneToOne
    @JoinColumn(name = "idfond")
    private FondCaisse fondCaisse;
    @OneToOne
    @JoinColumn(name = "idaide")
    private Aide aide;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idreunion")
    private Reunion reunion;

    public Long getIdseance() {
        return idseance;
    }

    public void setIdseance(Long idseance) {
        this.idseance = idseance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getJourreunion() {
        return jourreunion;
    }

    public void setJourreunion(Date jourreunion) {
        this.jourreunion = jourreunion;
    }

    public String getOrdredujour() {
        return ordredujour;
    }

    public void setOrdredujour(String ordredujour) {
        this.ordredujour = ordredujour;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public Date getJourtontine() {
        return jourtontine;
    }

    public void setJourtontine(Date jourtontine) {
        this.jourtontine = jourtontine;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Cotisation getCotisation() {
        return cotisation;
    }

    public void setCotisation(Cotisation cotisation) {
        this.cotisation = cotisation;
    }

    public Sention getSention() {
        return sention;
    }

    public void setSention(Sention sention) {
        this.sention = sention;
    }

    public Tontine getTontine() {
        return tontine;
    }

    public void setTontine(Tontine tontine) {
        this.tontine = tontine;
    }

    public FondCaisse getFondCaisse() {
        return fondCaisse;
    }

    public void setFondCaisse(FondCaisse fondCaisse) {
        this.fondCaisse = fondCaisse;
    }

    public Aide getAide() {
        return aide;
    }

    public void setAide(Aide aide) {
        this.aide = aide;
    }
}
