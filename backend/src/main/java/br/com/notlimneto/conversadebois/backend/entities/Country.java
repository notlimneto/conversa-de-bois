package br.com.notlimneto.conversadebois.backend.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    private String code;
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<State> states = new ArrayList<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.REFRESH)
    private List<Author> authors = new ArrayList<>();

    @JsonValue
    public String getCode() {
        return code;
    }

    public void addState(State state) {
        states.add(state);
        state.setCountry(this);
    }

    public void removeState(State state) {
        states.remove(state);
        state.setCountry(null);
    }
}
