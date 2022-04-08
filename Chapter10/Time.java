package Chapter10;

public class Time {
    private long hour;
    private long minute;
    private long second;
    public Time()
    {
        long num=System.currentTimeMillis();
        this.hour=num/1000/60/60%24;
        this.minute=num/1000/60%60;
        this.second=num/1000%60;
    }

    public Time(long num) {
        this.hour=num/1000/60/60%24;
        this.minute=num/1000/60%60;
        this.second=num/1000%60;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public void setMinute(long minute) {
        this.minute = minute;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }
    public void setTime(long num)
    {
        this.hour=num/1000/60/60%24;
        this.minute=num/1000/60%60;
        this.second=num/1000%60;
    }

}
