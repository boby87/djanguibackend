package ftg.djagui.Reunion.Model;

import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;

@Entity
public class Aide {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idaide;
    private String libelle;
    private double Montant;
    @ManyToOne
    @JoinColumn(name = "idmembre")
    private Membres membres;

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

    public Membres getMembres() {
        return membres;
    }

    public void setMembres(Membres membres) {
        this.membres = membres;
    }
}
