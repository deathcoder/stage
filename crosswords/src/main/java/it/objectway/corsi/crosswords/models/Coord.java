package it.objectway.corsi.crosswords.models;

import it.objectway.corsi.crosswords.enums.Direction;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public class Coord {
    private Integer x, y;
    private Direction direction;
    private  Word word;
    private  Crossword crossword;

    public Coord() { }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Crossword getCrossword() {
        return crossword;
    }

    public void setCrossword(Crossword crossword) {
        this.crossword = crossword;
    }
}
