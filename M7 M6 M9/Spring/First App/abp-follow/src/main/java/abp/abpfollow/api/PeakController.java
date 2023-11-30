package abp.abpfollow.api;

import abp.abpfollow.modelo.Peak;
import abp.abpfollow.modelo.PeaksRequest;
import abp.abpfollow.service.PeakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PeakController {

    @Autowired
    private PeakService peakService;

    @GetMapping("/peaks")
    private ResponseEntity getPeaks()
    {
        return this.peakService.getPeaks();
    }

    @PostMapping("/peaks")
    private ResponseEntity putPeaks(@RequestBody Peak peak) {

        return this.peakService.postPeaks(peak);

    }
    @PostMapping("/peaks/all")
    private ResponseEntity postPeaksAll(@RequestBody ArrayList<Peak> peaks) {

        return this.peakService.postPeaksAll(peaks);

    }

    @PostMapping("/peaksRequest")
    private ResponseEntity postPeaksRequest(@RequestBody PeaksRequest peaks) {

        return this.peakService.postPeaksRequest(peaks);

    }

    @PutMapping("/peaks/{name}")
    private ResponseEntity putPeaks(@RequestBody Peak peak, @PathVariable("name") String name){

        return this.peakService.putPeaks(peak, name);

    }

    @PutMapping("/peaks")
    private ResponseEntity putPeaksByPeakName(@RequestBody Peak peak, @RequestParam("name") String name) {

        return this.peakService.putPeaks(peak, name);

    }


}
