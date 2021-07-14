package ftg.lounk.Utilisateur.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ftg.lounk.Reunion.Model.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "membres")
@Inheritance(strategy = InheritanceType.JOINED)
public class Membres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmembre;
    private String nom;
    private String premon;
    private String sexe;
    @Column(unique = true)
    private String telephone;
    @Column(unique = true)
    private String emails;
    private boolean statut=true;
    @Column(columnDefinition = "text")
    private String image;
    private String password;
    @ManyToOne
    @JoinColumn(name = "idreunion")
    private Reunion reunion;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)//EAGER veut dire qu'a chaque fois que je charge un utilisateur il charge aussi ses roles
    //FetchType.EAGER : indique que la relation doit être chargée en même temps que l'entité qui la porte.
    Set<Roles> roles =new HashSet<>();
    @OneToMany(mappedBy = "membres")
    List<Cotisation> cotisations;
    @OneToMany(mappedBy = "membres")
    List<Tontine> tontines;
    @OneToMany(mappedBy = "membres")
    List<Aide> aides;
    @OneToMany(mappedBy = "membres")
    List<Sention> sentions;

    public Long getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(Long idmembre) {
        this.idmembre = idmembre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPremon() {
        return premon;
    }

    public void setPremon(String premon) {
        this.premon = premon;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }
}
