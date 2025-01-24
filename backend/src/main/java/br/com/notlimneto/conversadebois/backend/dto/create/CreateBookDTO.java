package br.com.notlimneto.conversadebois.backend.dto.create;

import java.util.List;

public record CreateBookDTO(String title, String description, Integer year, String style, List<Integer> authors) {
}
