package org.example;

public class TimeAndPrice implements Comparable<TimeAndPrice>{
    String time;
    String price;

    public TimeAndPrice(String time, String price) {
        this.time = time;
        this.price = price;
    }
    public int compareTo(TimeAndPrice other) {
        return Integer.compare(Integer.parseInt(this.price), Integer.parseInt(other.price));
    }
}
