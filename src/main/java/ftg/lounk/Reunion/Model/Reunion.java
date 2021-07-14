package ftg.lounk.Reunion.Model;

import ftg.lounk.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Reunion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreunion;
    private String libelle;
    private String telephone;
    private String email;
    private Date date;
    @OneToMany(mappedBy = "reunion")
    List<Membres> membres;
    @OneToMany(mappedBy = "reunion")
    List<Seances> seances;

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
}
