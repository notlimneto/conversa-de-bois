package br.com.notlimneto.conversadebois.backend.repositories;

import br.com.notlimneto.conversadebois.backend.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findById(Integer id);

    @Query(value = "SELECT a.id, a.name, a.birth_year, a.country_code, a.state_id, a.bio " +
            "FROM author a " +
            "WHERE unaccent(lower(a.name)) LIKE unaccent(lower(concat('%', :name, '%')))",
            nativeQuery = true
    )
    List<Author> searchByName(@Param("name") String name);
}
