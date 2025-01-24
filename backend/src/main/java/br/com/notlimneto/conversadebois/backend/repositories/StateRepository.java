package br.com.notlimneto.conversadebois.backend.repositories;

import br.com.notlimneto.conversadebois.backend.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StateRepository extends JpaRepository<State, Long> {

    State findById(Integer id);
    State findByName(String name);
    State findByCode(String code);

}
