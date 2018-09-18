package org.vincent.web.out;

import java.io.Serializable;

/**
 * Created by PengRong on 2018/9/18.
 * 设置 Body 返回数据的 json 数据格式
 */
public class JsonResult implements Serializable{
    private String status = null;

    private Object result = null;

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status='" + status + '\'' +
                ", result=" + result +
                '}';
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
