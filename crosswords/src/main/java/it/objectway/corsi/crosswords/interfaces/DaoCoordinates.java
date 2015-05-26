package it.objectway.corsi.crosswords.interfaces;

import it.objectway.corsi.crosswords.models.Coord;
import it.objectway.corsi.crosswords.models.Word;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public interface DaoCoordinates {
    Coord getCoord(Word word);
}
