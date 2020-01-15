package hu.dayroom.controller;

import hu.dayroom.model.domain.LogEntry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DayroomService {

    private final List<LogEntry> logEntries;

    public DayroomService(List<LogEntry> logEntries) {
        this.logEntries = logEntries;
    }

    public int getFirstInId() {
        return logEntries.get(0).getId();
    }

    public int getLastOutId() {
        return logEntries.stream()
                .sorted((j, i) -> i.getLogTime().toMinute().compareTo(j.getLogTime().toMinute()))
                .findFirst()
                .map(LogEntry::getId)
                .get();
    }

    public List<String> getIdMap() {
        return createMap().entrySet().stream()
                .map(i -> i.getKey() + " " + i.getValue())
                .collect(Collectors.toList());
    }

    public String getStayedIds() {
        return createMap().entrySet().stream()
                .filter(i -> i.getValue() % 2 == 1)
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    private Map<Integer, Long> createMap() {
        return logEntries.stream()
                .collect(Collectors.groupingBy(i -> i.getId(), Collectors.counting()));
    }
}
