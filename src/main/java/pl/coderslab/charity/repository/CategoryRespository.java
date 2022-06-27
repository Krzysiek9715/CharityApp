package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Category;

import java.util.List;

public interface CategoryRespository extends JpaRepository<Category,Long> {


    @Query("select c.name from Category c")
    List<String> names();
}
