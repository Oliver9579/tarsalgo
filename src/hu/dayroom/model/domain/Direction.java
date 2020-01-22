package hu.dayroom.model.domain;

import java.util.Arrays;

public enum Direction {
    IN("be"),
    OUT("ki");

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Direction getValue(String name) {
        return Arrays.stream(Direction.values())
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .get();
    }
}
