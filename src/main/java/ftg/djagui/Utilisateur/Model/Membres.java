package ftg.djagui.Utilisateur.Model;

import ftg.djagui.AideMembre.Model.Aide;
import ftg.djagui.AideMembre.Model.EnregistrementAide;
import ftg.djagui.Cotisation.Model.EnregistementCotisation;
import ftg.djagui.Reunion.Model.*;
import ftg.djagui.Sentions.Model.EnregistrerSentions;
import ftg.djagui.Tontine.Model.EnregistrerTontine;

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
    private String cni;
    private String sexe;
    private String telephone;
    private Date datenaissance;
    private String username;
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
    List<EnregistementCotisation> enregistementCotisations;
    @OneToMany(mappedBy = "membres")
    List<EnregistrerTontine> enregistrerTontines;
    @OneToMany(mappedBy = "membres")
    List<EnregistrementAide> enregistrementAides;
    @OneToMany(mappedBy = "membres")
    List<EnregistrerSentions> enregistrerSentions;

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

    public List<EnregistementCotisation> getEnregistementCotisations() {
        return enregistementCotisations;
    }

    public void setEnregistementCotisations(List<EnregistementCotisation> enregistementCotisations) {
        this.enregistementCotisations = enregistementCotisations;
    }

    public List<EnregistrementAide> getEnregistrementAides() {
        return enregistrementAides;
    }

    public void setEnregistrementAides(List<EnregistrementAide> enregistrementAides) {
        this.enregistrementAides = enregistrementAides;
    }

    public List<EnregistrerTontine> getEnregistrerTontines() {
        return enregistrerTontines;
    }

    public void setEnregistrerTontines(List<EnregistrerTontine> enregistrerTontines) {
        this.enregistrerTontines = enregistrerTontines;
    }

    public List<EnregistrerSentions> getEnregistrerSentions() {
        return enregistrerSentions;
    }

    public void setEnregistrerSentions(List<EnregistrerSentions> enregistrerSentions) {
        this.enregistrerSentions = enregistrerSentions;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
