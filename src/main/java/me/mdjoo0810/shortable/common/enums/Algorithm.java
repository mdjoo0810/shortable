package me.mdjoo0810.shortable.common.enums;

public enum Algorithm {
    SHA_256("SHA-256");

    private final String name;

    Algorithm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
