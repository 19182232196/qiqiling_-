package test15;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class order {
    private String id;
    private String time;
    private double price;
    private double count;
    private String namr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public String getNamr() {
        return namr;
    }

    public void setNamr(String namr) {
        this.namr = namr;
    }

    public order() {
        LocalDate now= LocalDate.now();
        this.time = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
    }

    public order(String id, double price, double count, String namr) {
        super();
        this.id = id;
        LocalDate now= LocalDate.now();
        this.time = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        this.price = count;
        this.count = count;
        this.namr = namr;
    }

    @Override
    public String toString() {
        return id+" "+namr+" "+count+" "+count+" "+time;
    }
}
