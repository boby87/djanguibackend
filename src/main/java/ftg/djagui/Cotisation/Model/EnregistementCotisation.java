package ftg.djagui.Cotisation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ftg.djagui.Tontine.Model.Tontine;
import ftg.djagui.Utilisateur.Model.Membres;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EnregistementCotisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenregistrementcotisation;
    private Date datetcotisation;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idmembre")
    private Membres membres;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idcotisation")
    private Cotisation cotisation;
}
