package me.mdjoo0810.shortable.common.enums;

public enum CookieKey {

    LOGIN_USER("LOGIN_USER");

    private final String value;

    CookieKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
