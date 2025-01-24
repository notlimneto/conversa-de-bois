package br.com.notlimneto.conversadebois.backend.repositories;

import br.com.notlimneto.conversadebois.backend.entities.Author;
import br.com.notlimneto.conversadebois.backend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long id);
    List<Book> findByYear(Integer year);

    @Query(value = "SELECT b.id, b.title, b.year, b.description, b.style " +
            "FROM book b " +
            "WHERE unaccent(lower(b.title)) LIKE unaccent(lower(concat('%', :title, '%')))",
            nativeQuery = true
    )
    List<Book> searchByTitle(@Param("title") String title);
}
