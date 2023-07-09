package model;

public class ShowTime {
    private String hour;

    public ShowTime(String showTime) {
        this.hour = showTime;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "ShowTime{" +
                "hour='" + hour + '\'' +
                '}';
    }
}
