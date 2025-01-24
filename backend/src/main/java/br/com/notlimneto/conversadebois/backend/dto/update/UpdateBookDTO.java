package br.com.notlimneto.conversadebois.backend.dto.update;

import java.util.List;

public record UpdateBookDTO(Long id, String title, Integer year, String description, String style, List<Integer> authors) {
}
