package abp.abpanime.anime.service;

import abp.abpanime.anime.api.AnimeController;
import abp.abpanime.anime.dao.AnimeRepository;
import abp.abpanime.anime.model.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class AnimeService {


    private AnimeRepository animeRepository;

    private AnimeService (AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    };

    public ResponseEntity getAnimes() {

        List<Anime> animes = animeRepository.getAnimes();

        if (animes.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay datos");
        } else {
            return ResponseEntity.ok().body(animes);
        }

    }

}
