package br.com.notlimneto.conversadebois.backend.controllers;

import br.com.notlimneto.conversadebois.backend.dto.create.CreateAuthorDTO;
import br.com.notlimneto.conversadebois.backend.dto.update.UpdateAuthorDTO;
import br.com.notlimneto.conversadebois.backend.entities.Author;
import br.com.notlimneto.conversadebois.backend.entities.Country;
import br.com.notlimneto.conversadebois.backend.entities.State;
import br.com.notlimneto.conversadebois.backend.enumeration.CountryEnum;
import br.com.notlimneto.conversadebois.backend.repositories.AuthorRepository;
import br.com.notlimneto.conversadebois.backend.repositories.CountryRepository;
import br.com.notlimneto.conversadebois.backend.repositories.StateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @PostMapping("")
    public ResponseEntity registerAuthor(@RequestBody @Valid CreateAuthorDTO data) {
        if (!CountryEnum.hasCountry(data.country())) return ResponseEntity.badRequest().build();
        Country country = countryRepository.findByCode(data.country());
        if (country == null) return ResponseEntity.badRequest().build();

        if (data.name() == null || data.name().isEmpty()) return ResponseEntity.badRequest().build();
        if (data.birthYear() == null) return ResponseEntity.badRequest().build();

        State state = this.stateRepository.findById(data.state());

        Author author = new Author();

        author.setName(data.name());
        author.setCountry(country);
        author.setState(state);
        author.setBirthYear(data.birthYear());
        this.authorRepository.save(author);

        return ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity updateAuthor(@RequestBody @Valid UpdateAuthorDTO data) {
        if (!CountryEnum.hasCountry(data.country())) return ResponseEntity.badRequest().build();
        Country country = countryRepository.findByCode(data.country());
        if (country == null) return ResponseEntity.badRequest().build();

        if (data.name() == null || data.name().isEmpty()) return ResponseEntity.badRequest().build();
        if (data.birthYear() == null) return ResponseEntity.badRequest().build();

        State state = this.stateRepository.findById(data.state());

        Author author = this.authorRepository.findById(data.id());
        if (author == null) return ResponseEntity.badRequest().build();

        author.setName(data.name());
        author.setCountry(country);
        author.setState(state);
        author.setBirthYear(data.birthYear());
        this.authorRepository.save(author);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> index(@PathVariable Integer id) {
        Author author = this.authorRepository.findById(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping("")
    public ResponseEntity<List<Author>> index(@RequestParam("search") String name) {
        List<Author> author = (name==null || name.isEmpty()) ? this.authorRepository.findAll() : this.authorRepository.searchByName(name);
        return ResponseEntity.ok(author);
    }
}
