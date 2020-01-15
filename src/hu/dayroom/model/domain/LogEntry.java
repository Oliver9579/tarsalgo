package hu.dayroom.model.domain;

public class LogEntry {

    private final LogTime logTime;
    private final int id;
    private final Direction direction;

    public LogEntry(LogTime logTime, int id, Direction direction) {
        this.id = id;
        this.direction = direction;
        this.logTime = logTime;
    }

    public int getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

    public LogTime getLogTime() {
        return logTime;
    }
}
