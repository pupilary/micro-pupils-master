package com.pupils.metadata;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author takesi
 * @date 2021-07-10
 */
public class Result extends HashMap<String, Object> {

    private static final String CODE = "code";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";

    private static Result result = null;

    private Result() {

    }

    public static synchronized Result getInstance() {
        if (result == null) {
            result = new Result();
        }
        return result;
    }

    public Result ok() {
        final HttpStatus ok = HttpStatus.OK;
        result.put(CODE, ok.value());
        result.put(MESSAGE, ok.getReasonPhrase());
        return result;
    }

    public <T> Result ok(T data) {
        final HttpStatus ok = HttpStatus.OK;
        result.put(CODE, ok.value());
        result.put(DATA, data);
        result.put(MESSAGE, ok.getReasonPhrase());
        return result;
    }

    public Result error() {
        final HttpStatus error = HttpStatus.INTERNAL_SERVER_ERROR;
        result.put(CODE, error.value());
        result.put(MESSAGE, error.getReasonPhrase());
        return result;
    }

    public Result error(HttpStatus error) {
        result.put(CODE, error.value());
        result.put(MESSAGE, error.getReasonPhrase());
        return result;
    }
}
