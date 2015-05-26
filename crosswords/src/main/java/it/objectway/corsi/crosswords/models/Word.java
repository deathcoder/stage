package it.objectway.corsi.crosswords.models;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public class Word {
    private long id;
    private String question;
    private String solution;

    public Word() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
