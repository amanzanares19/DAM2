package abp.abpfollow.api;

import abp.abpfollow.service.PeakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeakController {

    @Autowired
    private PeakService peakService;

    @GetMapping("/peaks")
    private ResponseEntity getPeaks()
    {
        return this.peakService.getPeaks();
    }

}
