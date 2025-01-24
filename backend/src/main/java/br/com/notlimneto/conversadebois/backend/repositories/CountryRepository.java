package br.com.notlimneto.conversadebois.backend.repositories;

import br.com.notlimneto.conversadebois.backend.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String name);
    Country findByCode(String code);
}
