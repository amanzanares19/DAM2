package abp.abpfollow.service;

import abp.abpfollow.modelo.Peak;
import abp.abpfollow.modelo.PeaksRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class PeakService {

    public ResponseEntity getPeaks() {

        ArrayList<Peak> peaks = new ArrayList<>();

        peaks.add(new Peak("Mi cima", 3000, "principal", new ArrayList<String>(), "Vizcaya"));

        if (peaks.size() == 0){
            return ResponseEntity.notFound().build();
        }
        if (peaks == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(peaks);

    }

    public ResponseEntity postPeaks(Peak peak) {

        ArrayList<Peak> peaks = new ArrayList<>();
        peaks.add(peak);

        return ResponseEntity.status(HttpStatus.CREATED).body(peaks);

    }

    public ResponseEntity postPeaksAll(ArrayList<Peak> peaks) {

        return ResponseEntity.status(HttpStatus.CREATED).body(peaks);

    }

    public ResponseEntity postPeaksRequest(PeaksRequest peaks) {
        return ResponseEntity.status(HttpStatus.CREATED).body(peaks.getPeaks());
    }

    public ResponseEntity putPeaks(Peak peak, String name) {

        System.out.println(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(peak);

    }
}
