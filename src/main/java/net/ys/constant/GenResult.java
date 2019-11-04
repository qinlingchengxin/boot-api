package net.ys.constant;

import java.util.LinkedHashMap;
import java.util.Map;

public enum GenResult {

    SUCCESS(1000, "request success"),

    FAILED(1001, "request failed"),

    PARAMS_ERROR(1002, "parameter error"),

    REQUEST_METHOD_ERROR(1003, "request method error"),

    REQUEST_INVALID(1004, "request invalid"),

    REQUEST_IP_INVALID(1006, "ip not on the list"),

    UNKNOWN_ERROR(9999, "unknown error");

    public int msgCode;
    public String message;

    GenResult(int msgCode, String message) {
        this.msgCode = msgCode;
        this.message = message;
    }

    public Map<String, Object> genResult(Object... data) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("code", msgCode);
        map.put("msg", message);
        if (data.length > 0) {
            map.put("data", data[0]);
        }
        return map;
    }

    public int getMsgCode() {
        return msgCode;
    }

    public String getMessage() {
        return message;
    }
}
