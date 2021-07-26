package ftg.djagui.Cotisation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ftg.djagui.Reunion.Model.Seances;
import ftg.djagui.Tontine.Model.EnregistrerTontine;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Cotisation {
    @Id
    private Long idcotisation;
    private Date datecotisation;
    private double montant;
    @JsonIgnore
    @OneToMany(mappedBy = "cotisation")
    private List<EnregistementCotisation> enregistementCotisations;

    @OneToOne(mappedBy = "cotisation")
    @PrimaryKeyJoinColumn
    private Seances seances;

    public Long getIdcotisation() {
        return idcotisation;
    }

    public void setIdcotisation(Long idcotisation) {
        this.idcotisation = idcotisation;
    }
    

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatecotisation() {
        return datecotisation;
    }

    public void setDatecotisation(Date datecotisation) {
        this.datecotisation = datecotisation;
    }

    public List<EnregistementCotisation> getEnregistementCotisations() {
        return enregistementCotisations;
    }

    public void setEnregistementCotisations(List<EnregistementCotisation> enregistementCotisations) {
        this.enregistementCotisations = enregistementCotisations;
    }

    public Seances getSeances() {
        return seances;
    }

    public void setSeances(Seances seances) {
        this.seances = seances;
    }
}
