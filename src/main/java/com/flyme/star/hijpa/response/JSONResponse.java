package com.flyme.star.hijpa.response;

import java.util.ArrayList;

public class JSONResponse {
    private boolean success = false;
    private String error;
    private ArrayList<String> errors = null;
    private Object result = null;

    public JSONResponse() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public ArrayList<String> getErrors() {
        return this.errors;
    }

    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
