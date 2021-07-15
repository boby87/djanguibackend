package ftg.djagui.Utilisateur.WebRestController;

import ftg.djagui.Utilisateur.Metier.MetierRoles;
import ftg.djagui.Utilisateur.Model.Roles;
import ftg.djagui.Utilisateur.WebRestController.Dto.DtoRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("role")
public class RestRoles {
    @Autowired
    MetierRoles metierRoles;

    @GetMapping("all")
    List<Roles> getAll(){
        return metierRoles.getAllrolle();
    }
    @GetMapping("by/{role}")
    Roles getBy(@PathVariable String role){
        return metierRoles.getrolebyname(role);
    }

    @PostMapping("add")
    Roles addRole(@RequestBody DtoRoles dtoRoles){
        return metierRoles.saverole(new Roles(dtoRoles.getRole()));
    }

    @PutMapping("update/{idrole}")
    Roles updateRole(@RequestBody DtoRoles dtoRoles,@PathVariable Long idrole){
        return metierRoles.updateRole(idrole, dtoRoles);
    }

    @GetMapping("change/statut/{idrole}")
    boolean changestatus(@PathVariable Long idrole){
        return metierRoles.desactiveOractive(idrole);
    }
}
