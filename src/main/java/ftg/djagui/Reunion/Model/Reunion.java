package ftg.djagui.Reunion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Reunion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreunion;
    @Column(unique = true)
    private String libelle;
    private String telephone;
    private double montanttontine;
    private String createur;
    private String email;
    private String devise;
    private Date date=new Date();
    @Column(columnDefinition = "text")
    private String logo;
    @Column(columnDefinition = "text")
    private String statuts;
    private boolean etat=true;
    @JsonIgnore
    @OneToMany(mappedBy = "reunion")
    List<Membres> membres;
    @OneToMany(mappedBy = "reunion")
    List<Seances> seances;

    public Reunion() {
    }

    public Reunion(String libelle, String telephone, String email, String logo) {
        this.libelle = libelle;
        this.telephone = telephone;
        this.email = email;
        this.logo = logo;
    }

    public Long getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Long idreunion) {
        this.idreunion = idreunion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Membres> getMembres() {
        return membres;
    }

    public void setMembres(List<Membres> membres) {
        this.membres = membres;
    }

    public List<Seances> getSeances() {
        return seances;
    }

    public void setSeances(List<Seances> seances) {
        this.seances = seances;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getMontanttontine() {
        return montanttontine;
    }

    public void setMontanttontine(double montanttontine) {
        this.montanttontine = montanttontine;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getStatuts() {
        return statuts;
    }

    public void setStatuts(String statuts) {
        this.statuts = statuts;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
