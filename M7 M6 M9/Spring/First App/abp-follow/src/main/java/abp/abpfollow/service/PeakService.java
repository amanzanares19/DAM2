package abp.abpfollow.service;

import abp.abpfollow.dao.OtherRepository;
import abp.abpfollow.dao.PeakRepository;
import abp.abpfollow.modelo.Peak;
import abp.abpfollow.modelo.PeaksRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeakService {

    @Autowired
    private PeakRepository peakR;
    @Autowired
    private OtherRepository otherR;

    public ResponseEntity getPeaks() {

        List<Peak> peaks = this.peakR.findAll();

        if (peaks.size() == 0){
            return ResponseEntity.notFound().build();
        }

        if (peaks == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(peaks);

    }
    /* before peakrepo
    public ResponseEntity getPeaks() {

        ArrayList<Peak> peaks = new ArrayList<>();

        peaks.add(new Peak("Mi cima", 3000, "principal",
                "Vizcaya", new ArrayList<Other>(), new Other()));

        if (peaks.size() == 0){
            return ResponseEntity.notFound().build();
        }
        if (peaks == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(peaks);

    }*/

    public ResponseEntity postPeaks(Peak peak) {

        this.peakR.save(peak);
        return ResponseEntity.status(HttpStatus.CREATED).body(peak);

    }
    /* Before peakrepo
    public ResponseEntity postPeaks(Peak peak) {

        ArrayList<Peak> peaks = new ArrayList<>();
        peaks.add(peak);

        return ResponseEntity.status(HttpStatus.CREATED).body(peaks);

    }*/

    public ResponseEntity postPeaksAll(List<Peak> peaks) {

        this.peakR.saveAllAndFlush(peaks);
        for (Peak p :
                peaks) {
            if (p.getOther() != null) {
                this.otherR.saveAll(p.getOther());
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(peaks);

    }
    /*public ResponseEntity postPeaksAll(ArrayList<Peak> peaks) {

        return ResponseEntity.status(HttpStatus.CREATED).body(peaks);

    }*/

    public ResponseEntity postPeaksRequest(PeaksRequest peaks) {
        return ResponseEntity.status(HttpStatus.CREATED).body(peaks.getPeaks());
    }

    public ResponseEntity putPeaks(Peak peak, String name) {

        peak.setPeak(name);
        this.peakR.saveAndFlush(peak);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    /*public ResponseEntity putPeaks(Peak peak, String name) {

        System.out.println(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(peak);

    }*/
    public ResponseEntity deletePeaks(String name) {


        List<Peak> peaks = this.peakR.findAll();
        for (Peak peak:
             peaks) {
            if (peak.getPeak().equals(name)){
                this.peakR.delete(peak);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }
        return ResponseEntity.badRequest().build();


    }
    /*public ResponseEntity deletePeaks(String name) {

        System.out.println(name);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todo OK");

    }*/
}
