package org.vincent.web.out;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PengRong on 2018/9/18.
 * 设置 Body 返回数据的 json 数据格式
 */
public class JsonResult extends BaseResult implements Serializable{
    /**
     * 返回数据的有效载荷
     */
    private Map<String,Object> result=new HashMap<String,Object>();

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> data) {
        this.result = data;
    }
}
