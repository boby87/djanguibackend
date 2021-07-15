package ftg.djagui.Utilisateur.Model;

import javax.persistence.*;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrole;
    @Column(unique = true)
    private String role;
    private boolean statuts=true;

    public Roles() {
    }

    public Roles(String role) {
        this.role = role;
    }

    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatuts() {
        return statuts;
    }

    public void setStatuts(boolean statuts) {
        this.statuts = statuts;
    }
}
