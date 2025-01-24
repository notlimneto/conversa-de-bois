package br.com.notlimneto.conversadebois.backend.enumeration;

public enum StyleEnum {
    POESIA("Poesia"),
    ROMANCE("Romance"),
    NOVELA("Novela"),
    CONTO("Conto"),
    CRONICA("Crônica"),
    DRAMA("Drama"),
    ENSAIO("Ensaio"),
    EPOPEIA("Epopeia"),
    FABULA("Fábula"),
    PARABOLA("Parábola"),
    AUTOBIOGRAFIA("Autobiografia"),
    BIOGRAFIA("Biografia"),
    MEMORIAS("Memórias"),
    EPISTOLOGRAFIA("Carta/Epistolografia"),
    DIARIO("Diário"),
    TRAGEDIA("Tragédia"),
    COMEDIA("Comédia"),
    LITERATURA_FANTASTICA("Literatura Fantástica"),
    LITERATURA_DE_CORDEL("Literatura de Cordel"),
    MANIFESTO("Manifesto");

    private String style;

    StyleEnum(String style) {
        this.style = style;
    }
}
