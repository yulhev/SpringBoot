package lt.vilniustech.YHev.first.controller;
import lt.vilniustech.YHev.first.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling service A related requests.
 */
@RestController
@RequestMapping("/serviceA")
public class DisplayPathController {
    @Autowired
    private TestConfig testConfig;
    /**
     * Endpoint to display path information.
     */
    @GetMapping("/displayPath")
    public ResponseEntity<String> showMessage() {
        return ResponseEntity.ok("Microservice 1 controller executed. Path=="+testConfig.getFoo());}
}
