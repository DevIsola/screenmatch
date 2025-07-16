package br.com.alura.screenmatch.model.enums;

public enum GenresEnum {
    ACTION ("action"),
    ROMANCE ("romance"),
    COMEDY ("comedy"),
    DRAMA ("drama"),
    CRIME ("crime"),
    THRILLER ("thriller"),
    HORROR ("horror"),
    FANTASY ("fantasy"),
    SCIENCE_FICTION ("science fiction"),
    DOCUMENTARY ("documentary"),
    ANIMATION ("animation"),
    ADVENTURE ("adventure"),
    MYSTERY ("mystery"),
    WESTERN ("western"),;

    private String genreOmdb;

    GenresEnum(String genreOmdb) {
        this.genreOmdb = genreOmdb;
    }

    public static GenresEnum fromString(String g) {
        for (GenresEnum genre : GenresEnum.values()) {
            if (genre.genreOmdb.equalsIgnoreCase(g)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("No matching genre found for: " + g);
    }

}
