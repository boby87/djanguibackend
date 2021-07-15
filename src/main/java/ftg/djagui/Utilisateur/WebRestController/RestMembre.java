package ftg.djagui.Utilisateur.WebRestController;

import ftg.djagui.Utilisateur.WebRestController.Dto.DtoMembre;
import ftg.djagui.Utilisateur.Metier.MetierMembre;
import ftg.djagui.Utilisateur.Model.Membres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("membre")
public class RestMembre {
    @Autowired
    MetierMembre metierMembre;

    @GetMapping("by/{login}")
    Membres getMembre(@PathVariable String login){
        return metierMembre.findByUsernameOrEmailOrPhone(login);
    }
    @GetMapping("all")
    List<Membres> getall(){
        return metierMembre.getAllmembre();
    }

    @PostMapping("register")
    Membres registerMembre(@RequestBody DtoMembre dtoMembre){
        return metierMembre.save(dtoMembre);
    }

    @PutMapping("update/{idmembre}")
    Membres updateMembre(@RequestBody DtoMembre dtoMembre,@PathVariable Long idmembre){
        return metierMembre.update(dtoMembre,idmembre);
    }

    @PutMapping("update/roles/{role}/{idmembre}")
    Membres updateMembre(@PathVariable String role,@PathVariable Long idmembre){
        return metierMembre.changeRoleMembre(role,idmembre);
    }

}
