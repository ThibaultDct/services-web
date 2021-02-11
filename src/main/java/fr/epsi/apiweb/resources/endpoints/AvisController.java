package fr.epsi.apiweb.resources.endpoints;

import fr.epsi.apiweb.resources.dto.AvisDTO;
import fr.epsi.apiweb.resources.entities.AvisEntity;
import fr.epsi.apiweb.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AvisController {

    @Autowired
    private AvisService avisService;

    @GetMapping("/avis/")
    public List<AvisEntity> retrieveAllAvis(){
        return avisService.getAll();
    }

    @GetMapping("/games/{id}/avis/")
    public List<AvisEntity> retrieveAvisFromGame(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        return avisService.getAvisByGame(uuid);
    }

    @PostMapping(value = "/games/{id}/avis", consumes = "application/json", produces = "application/json")
    public void addAvis(@RequestBody AvisDTO avisDTO, @PathVariable String id){
        UUID uuid = UUID.fromString(id);
        avisService.createFromDto(avisDTO, uuid);
    }

    @GetMapping("/avis/{id}/addLike")
    public void addLikeToAvis(@PathVariable String id){
        UUID avis_uuid = UUID.fromString(id);
        avisService.addLikeToAvis(avis_uuid);
    }

    @GetMapping("/avis/{id}/addDislike")
    public void addDislikeToAvis(@PathVariable String id){
        UUID avis_uuid = UUID.fromString(id);
        avisService.addDislikeToAvis(avis_uuid);
    }

    @GetMapping("/avis/{id}/removeLike")
    public void removeLikeToAvis(@PathVariable String id){
        UUID avis_uuid = UUID.fromString(id);
        avisService.removeLikeToAvis(avis_uuid);
    }

    @GetMapping("/avis/{id}/removeDislike")
    public void removeDislikeToAvis(@PathVariable String id){
        UUID avis_uuid = UUID.fromString(id);
        avisService.removeDislikeToAvis(avis_uuid);
    }

}
