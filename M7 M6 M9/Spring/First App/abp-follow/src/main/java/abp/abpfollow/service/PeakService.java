package abp.abpfollow.service;

import abp.abpfollow.modelo.Peak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PeakService {

    public ResponseEntity getPeaks() {

        ArrayList<Peak> peaks = new ArrayList<>();

        peaks.add(new Peak("Mi cima", 3000, "principal", new ArrayList<String>(), "Vizcaya"));
        return ResponseEntity.ok(peaks);

    }
}
