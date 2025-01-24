package br.com.notlimneto.conversadebois.backend.repositories;

import br.com.notlimneto.conversadebois.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByUsername(String username);
    UserDetails findByEmail(String email);

}
