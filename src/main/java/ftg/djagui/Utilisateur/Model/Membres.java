package ftg.djagui.Utilisateur.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ftg.djagui.Reunion.Model.*;

import javax.persistence.*;
import java.util.Date;
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
    private String nomcomplet;
    @Column(unique = true)
    private String cni;
    private String sexe;
    @Column(unique = true)
    private String telephone;
    @Column(unique = true)
    private String emails;
    private boolean statut=true;
    @Column(columnDefinition = "text")
    private String image;
    private String password;
    private Date date=new Date();
    @ManyToOne
    @JoinColumn(name = "idreunion")
    private Reunion reunion;
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

    public Membres() {
    }

    public Membres(String nomcomplet, String cni, String sexe, String telephone, String emails, String image, String password) {
        this.nomcomplet = nomcomplet;
        this.cni = cni;
        this.sexe = sexe;
        this.telephone = telephone;
        this.emails = emails;
        this.image = image;
        this.password = password;
    }

    public Long getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(Long idmembre) {
        this.idmembre = idmembre;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public void setNomcomplet(String nom) {
        this.nomcomplet = nom;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String premon) {
        this.cni = premon;
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

    public List<Cotisation> getCotisations() {
        return cotisations;
    }

    public void setCotisations(List<Cotisation> cotisations) {
        this.cotisations = cotisations;
    }

    public List<Tontine> getTontines() {
        return tontines;
    }

    public void setTontines(List<Tontine> tontines) {
        this.tontines = tontines;
    }

    public List<Aide> getAides() {
        return aides;
    }

    public void setAides(List<Aide> aides) {
        this.aides = aides;
    }

    public List<Sention> getSentions() {
        return sentions;
    }

    public void setSentions(List<Sention> sentions) {
        this.sentions = sentions;
    }
}
