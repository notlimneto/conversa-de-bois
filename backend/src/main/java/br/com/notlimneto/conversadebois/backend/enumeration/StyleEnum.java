package br.com.notlimneto.conversadebois.backend.enumeration;

import lombok.Getter;

@Getter
public enum StyleEnum {
    AUTOBIOGRAFIA("Autobiografia"),
    BIOGRAFIA("Biografia"),
    COMEDIA("Comédia"),
    CONTO("Conto"),
    CONTOS("Contos"),
    CRONICA("Crônica"),
    DIARIO("Diário"),
    DRAMA("Drama"),
    ENSAIO("Ensaio"),
    EPISTOLOGRAFIA("Carta/Epistolografia"),
    EPOPEIA("Epopeia"),
    FABULA("Fábula"),
    LITERATURA_DE_CORDEL("Literatura de Cordel"),
    LITERATURA_FANTASTICA("Literatura Fantástica"),
    MANIFESTO("Manifesto"),
    MEMORIAS("Memórias"),
    NOVELA("Novela"),
    PARABOLA("Parábola"),
    POESIA("Poesia"),
    ROMANCE("Romance"),
    TRAGEDIA("Tragédia");

    private final String style;

    StyleEnum(String style) {
        this.style = style;
    }

    public static boolean hasStyle(String style) {
        for (StyleEnum styleEnum : StyleEnum.values()) {
            if (styleEnum.getStyle().equals(style)) return true;
        }
        return false;
    }
}
