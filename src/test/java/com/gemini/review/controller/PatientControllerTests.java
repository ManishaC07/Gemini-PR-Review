import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class PatientControllerTests {

    @InjectMocks
    PatientController patientController;
    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }
}