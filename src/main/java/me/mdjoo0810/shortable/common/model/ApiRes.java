package me.mdjoo0810.shortable.common.model;

import lombok.Getter;

@Getter
public class ApiRes<T> {

    private final boolean success;
    private final String message;
    private final T data;

    protected ApiRes(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T>  ApiRes<T> success(T data) {
        return new ApiRes<>(true, "success", data);
    }

    public static <T> ApiRes<T> fail(String message) {
        return new ApiRes<>(false, message, null);
    }

}
