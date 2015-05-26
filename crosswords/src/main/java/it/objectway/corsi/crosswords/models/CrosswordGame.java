package it.objectway.corsi.crosswords.models;

import java.util.List;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public class CrosswordGame {
    private Crossword crossword;
    private List<Coord> coords;

    public void setCrossword(Crossword crossword) {
        this.crossword = crossword;
    }

    public void setCoords(List<Coord> coords) {
        this.coords = coords;
    }

    public String getName() {
        return crossword.getName();
    }
    
}
