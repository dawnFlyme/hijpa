package com.flyme.star.hijpa.base;


import com.flyme.star.hijpa.response.JSONResponse;

import java.util.ArrayList;
import java.util.Collection;

public class JSONController {
    public JSONController() {
    }

    protected JSONResponse success(Object obj) {
        JSONResponse ret = new JSONResponse();
        ret.setSuccess(true);
        ret.setResult(obj);
        return ret;
    }

    protected JSONResponse fail(String msg) {
        ArrayList<String> errors = new ArrayList();
        errors.add(msg);
        JSONResponse ret = new JSONResponse();
        ret.setSuccess(false);
        ret.setError(msg);
        return ret;
    }

    protected JSONResponse fail(Collection<String> errs) {
        ArrayList<String> errors = new ArrayList();
        errors.addAll(errs);
        JSONResponse ret = new JSONResponse();
        ret.setSuccess(false);
        ret.setErrors(errors);
        return ret;
    }
}
