package ftg.djagui.Reunion.WebRest;

import ftg.djagui.Reunion.Metier.MetierReunion;
import ftg.djagui.Reunion.Model.Reunion;
import ftg.djagui.Reunion.WebRest.Dto.DtoReunion;
import ftg.djagui.Utilisateur.Model.Membres;
import ftg.djagui.Utilisateur.WebRestController.Dto.DtoMembre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("reunion")
public class RestReunion {

    @Autowired
    MetierReunion metierReunion;

    @PostMapping("add/{idpresident}")
    Reunion addReunion(@RequestBody DtoReunion dtoReunion,@PathVariable Long idpresident){
        return metierReunion.saveReunion(dtoReunion,idpresident);
    }
    @GetMapping("all")
    List<Reunion> getAll(){
        return metierReunion.getAll();
    }
    @GetMapping("by/{reunion}")
    Reunion getBy(@PathVariable String reunion){
        return metierReunion.getByname(reunion);
    }
    @PutMapping("update/{idreunion}")
    Reunion update(@RequestBody DtoReunion dtoReunion, @PathVariable Long idreunion){
        return metierReunion.updateReunion(idreunion, dtoReunion);
    }

    @PutMapping("add/membre/{idpresident}")
    Membres addMembre(@RequestBody DtoMembre dtoMembre, @PathVariable Long idpresident){
        return metierReunion.addMembreToReunion(dtoMembre, idpresident);
    }
}
