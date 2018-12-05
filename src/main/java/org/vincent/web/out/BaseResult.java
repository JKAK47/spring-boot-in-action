package org.vincent.web.out;

/**
 * Created by PengRong on 2018/12/5.
 */
public class BaseResult {
    /**
     * 自定义状态码
     */
    private String code = "200";
    /**
     * 返回Msg
     */
    private String msg = "ok";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
