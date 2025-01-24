package br.com.notlimneto.conversadebois.backend.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_code", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "state", cascade = CascadeType.REFRESH)
    private List<Author> authors = new ArrayList<>();

    @JsonValue
    public Integer getId() {
        return id;
    }
}
