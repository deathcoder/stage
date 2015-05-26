package it.objectway.corsi.crosswords.models;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public class Crossword {
    private String name;
    private Integer rows, columns;

    public Crossword() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }
}
