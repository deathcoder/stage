package it.objectway.corsi.crosswords.interfaces;

import it.objectway.corsi.crosswords.models.CrosswordGame;

import java.util.List;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public interface DaoManager {
    List<String> getCrosswordNames();

    CrosswordGame getCrosswordGame(String name);
}
