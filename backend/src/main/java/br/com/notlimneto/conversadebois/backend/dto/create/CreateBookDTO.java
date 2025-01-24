package br.com.notlimneto.conversadebois.backend.dto.create;

public record CreateBookDTO(String title, String description, Integer year, Integer authorId, String style) {
}
