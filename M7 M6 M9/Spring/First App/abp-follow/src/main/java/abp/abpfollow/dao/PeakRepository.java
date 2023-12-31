package abp.abpfollow.dao;

import abp.abpfollow.modelo.Peak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeakRepository extends JpaRepository<Peak, Integer> {

    @Query(value = "SELECT p FROM Peak p ORDER BY p.peak")
    List<Peak> findAll();


}
