package model;

public class Point {
    private Integer amount;
    private Integer time;

    public Point(Integer amount, Integer time){
        this.amount = amount;
        this.time = time;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Point{" +
                "amount=" + amount +
                ", time=" + time +
                '}';
    }
}
