package abp.abpanime.anime.api;

import abp.abpanime.anime.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping("/welcome")
    public ResponseEntity Welcome() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/animes")
    public ResponseEntity getAllAnimes() {
        return this.animeService.getAnimes();
    }

}
