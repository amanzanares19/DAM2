package abp.abpfollow.dao;

import abp.abpfollow.modelo.Other;
import abp.abpfollow.modelo.Peak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OtherRepository extends JpaRepository<Other, Integer> {

    @Query(value = "SELECT o FROM Other o ORDER BY o.other")
    List<Other> findAll();


}
