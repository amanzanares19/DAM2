package abp.abpanime.anime.dao;

import abp.abpanime.anime.model.Anime;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimeRepository {

    private final String GET_ANIMES = "call Anime.getAnimes()";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnimeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Anime> getAnimes() {
        return jdbcTemplate.query("SQL", new BeanPropertyRowMapper<>(Anime.class));
    }
    public Anime getAnimeById(String id) {
        return jdbcTemplate.queryForObject("SQL", new BeanPropertyRowMapper<>(Anime.class));
    }

}
