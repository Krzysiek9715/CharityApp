package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Category;

public interface CategoryRespository extends JpaRepository<Category,Long> {


}
