package app.utils;

public class TimeCounter {
    private long startTime;
    private long endTime;

    public void startCounter() {
        startTime = System.currentTimeMillis();
    }

    public void stopCounter() {
        endTime = System.currentTimeMillis();
    }

    public long calculateElapsedTimeInSeconds() {
        return ((endTime - startTime) / 1000) % 60;
    }

    public long calculateElapsedTimeInMillis() {
        return endTime - startTime;
    }
}