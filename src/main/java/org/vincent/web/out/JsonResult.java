package org.vincent.web.out;

import java.io.Serializable;

/**
 * Created by PengRong on 2018/9/18.
 */
public class JsonResult implements Serializable{
    private String status = null;

    private Object result = null;

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
