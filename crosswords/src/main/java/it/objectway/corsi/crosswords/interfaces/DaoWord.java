package it.objectway.corsi.crosswords.interfaces;

import it.objectway.corsi.crosswords.models.Word;

import java.util.List;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public interface DaoWord {
    Word getWord(long id);

    List<String> getWordList();

    long getWordId(String word);
}
