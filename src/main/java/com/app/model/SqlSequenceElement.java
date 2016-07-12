package com.app.model;

/**
 * Created by Oussama on 12/07/2016.
 */
public class SqlSequenceElement {

    private String name;
    private String seq;

    public SqlSequenceElement(String name, String seq) {
        this.name = name;
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
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
