package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {

    @Query("select i.name from Institution i")
    List<String> names();

}
