package ftg.djagui.Reunion.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Seances {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idseance;
    private Date date;
    private String libelle;//les differentes date de la reunion
    private Date jourreunion;
    private String ordredujour;
    private String rapport;
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
}
