package ftg.djagui.Reunion.WebRest.Dto;

import javax.persistence.Column;
import java.util.Date;

public class DtoReunion {
    private String libelle;
    private String telephone;
    private String email;
    private String logo;
    private double montanttontine;
    private String devise;
    private String statuts;
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
}
