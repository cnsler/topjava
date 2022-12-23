package ru.javawebinar.topjava.util.exception;

import java.util.List;

public class ErrorInfo {
    private final String url;
    private final String type;
    private final List<String> details;

    public ErrorInfo(CharSequence url, String type, List<String> details) {
        this.url = url.toString();
        this.type = type;
        this.details = details;
    }
}