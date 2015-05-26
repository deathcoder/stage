package it.objectway.corsi.crosswords.interfaces;

import it.objectway.corsi.crosswords.models.Crossword;

import java.util.List;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public interface DaoCrossword {
    Crossword getCrossword(String name);

    List<String> getCrosswordNames();
}
