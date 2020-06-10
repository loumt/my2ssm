package cn.mt.controllers;

import cn.mt.utils.ResultEnum;
import com.alibaba.fastjson.JSONObject;

public class BaseController {

    private static final String CODE = "code";
    private static final String IS_SUCCESS = "isSuccess";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";

    private JSONObject base_init(ResultEnum e) {
        JSONObject result = new JSONObject();
        result.put(CODE,e.getCode());
        result.put(MESSAGE,e.getMessage());
        result.put(IS_SUCCESS,e.getSuccess());
        return result;
    }

    protected JSONObject success() {
        return base_init(ResultEnum.SUCCESS);
    }

    protected JSONObject failure() {
        return base_init(ResultEnum.FAILURE);
    }

    protected JSONObject failure(ResultEnum e) {
        return base_init(e);
    }

    protected JSONObject success(Object data) {
        JSONObject result = success();
        result.put(DATA, data);
        return result;
    }

}
