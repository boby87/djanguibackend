package ftg.djagui.Reunion.Model;

import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;

@Entity
public class Sention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsention;
    private double montant;
    private String libelle;
    @ManyToOne()
    @JoinColumn(name = "idmembre")
    private Membres membres;

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

    public Membres getMembres() {
        return membres;
    }

    public void setMembres(Membres membres) {
        this.membres = membres;
    }
}
