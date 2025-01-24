package br.com.notlimneto.conversadebois.backend.controllers;

import br.com.notlimneto.conversadebois.backend.dto.create.CreateBookDTO;
import br.com.notlimneto.conversadebois.backend.dto.update.UpdateBookDTO;
import br.com.notlimneto.conversadebois.backend.entities.Author;
import br.com.notlimneto.conversadebois.backend.entities.Book;
import br.com.notlimneto.conversadebois.backend.enumeration.StyleEnum;
import br.com.notlimneto.conversadebois.backend.repositories.AuthorRepository;
import br.com.notlimneto.conversadebois.backend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("")
    public ResponseEntity createBook(@RequestBody CreateBookDTO data) {

        if (!StyleEnum.hasStyle(data.style())) return ResponseEntity.badRequest().build();

        if (data.authors() == null || data.authors().isEmpty()) return ResponseEntity.badRequest().build();
        if (data.title() == null || data.title().isEmpty()) return ResponseEntity.badRequest().build();
        if (data.year() == null) return ResponseEntity.badRequest().build();

        List<Author> authors = new ArrayList<>();
        for (Integer authorId : data.authors()) {
           Author author = this.authorRepository.findById(authorId);
           if (author == null) return ResponseEntity.badRequest().build();
           else authors.add(author);
        }

        Book book = new Book();

        book.setYear(data.year());
        book.setTitle(data.title());
        book.setDescription(data.description());
        book.setStyle(data.style());
        book.setAuthors(authors);

        bookRepository.save(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity updateBook(@RequestBody UpdateBookDTO data) {

        if (!StyleEnum.hasStyle(data.style())) return ResponseEntity.badRequest().build();

        if (data.authors() == null || data.authors().isEmpty()) return ResponseEntity.badRequest().build();
        if (data.title() == null || data.title().isEmpty()) return ResponseEntity.badRequest().build();
        if (data.year() == null) return ResponseEntity.badRequest().build();

        List<Author> authors = new ArrayList<>();
        for (Integer authorId : data.authors()) {
            Author author = this.authorRepository.findById(authorId);
            if (author == null) return ResponseEntity.badRequest().build();
            else authors.add(author);
        }

        Book book = this.bookRepository.findById(data.id()).orElse(null);
        if (book == null) return ResponseEntity.badRequest().build();

        book.setYear(data.year());
        book.setTitle(data.title());
        book.setDescription(data.description());
        book.setStyle(data.style());
        book.setAuthors(authors);

        bookRepository.save(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> index(@RequestParam("search") String title) {
        List<Book> books = this.bookRepository.searchByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> index(@PathVariable Long id) {
        Book book = this.bookRepository.findById(id).orElse(null);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
