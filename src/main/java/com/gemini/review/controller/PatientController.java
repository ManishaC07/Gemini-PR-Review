import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PatientController {
    @GetMapping("/getPatient")
    public ResponseEntity getPatient(@RequestParam int id){
         return ResponseEntity.ok().body(null);
    }
}