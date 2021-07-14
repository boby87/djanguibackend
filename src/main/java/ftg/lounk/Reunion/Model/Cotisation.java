package ftg.lounk.Reunion.Model;

import ftg.lounk.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cotisation {
    @Id
    private Long idcotisation;
    private Date futurcotisation;
    private Date date;
    private double montant;
    @ManyToOne()
    @JoinColumn(name = "idmembre")
    private Membres membres;

    public Long getIdcotisation() {
        return idcotisation;
    }

    public void setIdcotisation(Long idcotisation) {
        this.idcotisation = idcotisation;
    }

    public Date getFuturcotisation() {
        return futurcotisation;
    }

    public void setFuturcotisation(Date futurcotisation) {
        this.futurcotisation = futurcotisation;
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

    public Membres getMembres() {
        return membres;
    }

    public void setMembres(Membres membres) {
        this.membres = membres;
    }
}
