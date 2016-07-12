package com.app.model;

/**
 * Created by Oussama on 12/07/2016.
 */
public class SqlSequenceElement {

    private String name;
    private int seq;

    public SqlSequenceElement(String name, int seq) {
        this.name = name;
        this.seq = seq;
    }

    public SqlSequenceElement(SqlSequenceElement other) {
        this.name = other.name;
        this.seq = other.seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "SqlSequenceElement{" +
                "name='" + name + '\'' +
                ", seq='" + seq + '\'' +
                '}';
    }
}
