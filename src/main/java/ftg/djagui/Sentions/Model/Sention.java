package ftg.djagui.Sentions.Model;

import ftg.djagui.Reunion.Model.Seances;
import ftg.djagui.Tontine.Model.EnregistrerTontine;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsention;
    private double montant;
    private String libelle;
    @OneToMany(mappedBy = "sention")
    private List<EnregistrerSentions> enregistrerSentions;
    @OneToOne(mappedBy = "sention")
    @PrimaryKeyJoinColumn
    private Seances seances;

    public Long getIdsention() {
        return idsention;
    }

    public void setIdsention(Long idsention) {
        this.idsention = idsention;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


}
