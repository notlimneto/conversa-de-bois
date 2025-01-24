package br.com.notlimneto.conversadebois.backend.repositories;

import br.com.notlimneto.conversadebois.backend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long id);
    List<Book> findByYear(Integer year);
}
