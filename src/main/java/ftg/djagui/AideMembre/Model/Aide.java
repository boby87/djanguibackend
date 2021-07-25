package ftg.djagui.AideMembre.Model;

import ftg.djagui.FondCasisse.Model.EnregistrerFondcaisse;
import ftg.djagui.Reunion.Model.Seances;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aide {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idaide;
    private String libelle;
    private double Montant;
    @OneToMany(mappedBy = "aide")
    private List<EnregistrementAide> enregistrementAides;
    @OneToOne(mappedBy = "aide")
    @PrimaryKeyJoinColumn
    private Seances seances;

    public Long getIdaide() {
        return idaide;
    }

    public void setIdaide(Long idaide) {
        this.idaide = idaide;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getMontant() {
        return Montant;
    }

    public void setMontant(double montant) {
        Montant = montant;
    }

    public List<EnregistrementAide> getEnregistrementAides() {
        return enregistrementAides;
    }

    public void setEnregistrementAides(List<EnregistrementAide> enregistrementAides) {
        this.enregistrementAides = enregistrementAides;
    }

    public Seances getSeances() {
        return seances;
    }

    public void setSeances(Seances seances) {
        this.seances = seances;
    }
}
