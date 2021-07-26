package ftg.djagui.Tontine.Model;

import ftg.djagui.Reunion.Model.Seances;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tontine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtontine;
    private Date date=new Date();
    private double montant;
    private boolean status=true;
  @OneToMany(mappedBy = "tontine")
  private List<EnregistrerTontine> enregistrerTontines;
  @OneToOne(mappedBy = "tontine")
  @PrimaryKeyJoinColumn
  private Seances seances;

    public Tontine() {
    }

    public Tontine(double montant) {
        this.montant = montant;
    }

    public Long getIdtontine() {
        return idtontine;
    }

    public void setIdtontine(Long idtontine) {
        this.idtontine = idtontine;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<EnregistrerTontine> getMembreTontines() {
        return enregistrerTontines;
    }

    public void setMembreTontines(List<EnregistrerTontine> enregistrerTontines) {
        this.enregistrerTontines = enregistrerTontines;
    }

    public List<EnregistrerTontine> getEnregistrerTontines() {
        return enregistrerTontines;
    }

    public void setEnregistrerTontines(List<EnregistrerTontine> enregistrerTontines) {
        this.enregistrerTontines = enregistrerTontines;
    }

    public Seances getSeances() {
        return seances;
    }

    public void setSeances(Seances seances) {
        this.seances = seances;
    }

}
