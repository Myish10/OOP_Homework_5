package models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000;
    private final int id;
    private Date date;
    private String name;
    private final Table table;

    public int getId() {
        return id;
    }

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
        id = ++counter;
    }
}
