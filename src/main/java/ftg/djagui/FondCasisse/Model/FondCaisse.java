package ftg.djagui.FondCasisse.Model;

import ftg.djagui.Reunion.Model.Seances;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class FondCaisse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfond;
    private Date date=new Date();
    private double montant;
    private boolean status=true;
  @OneToMany(mappedBy = "fondCaisse")
  private List<EnregistrerFondcaisse> enregistrerFondcaisses;
  @OneToOne(mappedBy = "fondCaisse")
  @PrimaryKeyJoinColumn
  private Seances seances;

    public FondCaisse() {
    }

    public Long getIdfond() {
        return idfond;
    }

    public void setIdfond(Long idfond) {
        this.idfond = idfond;
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

    public List<EnregistrerFondcaisse> getEnregistrerFondcaisses() {
        return enregistrerFondcaisses;
    }

    public void setEnregistrerFondcaisses(List<EnregistrerFondcaisse> enregistrerFondcaisses) {
        this.enregistrerFondcaisses = enregistrerFondcaisses;
    }

    public Seances getSeances() {
        return seances;
    }

    public void setSeances(Seances seances) {
        this.seances = seances;
    }
}
