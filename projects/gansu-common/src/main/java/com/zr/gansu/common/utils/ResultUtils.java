package com.zr.gansu.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kaiZhang
 */
public class ResultUtils {

    private static int SUCCESS = 1;
    private static int ERROR = 0;

    private static String CODE = "code";
    private static String DATA = "data";
    private static String MSG = "msg";
    private static String ERRNO = "errno";

    public static Map<String, Object> success(Object data, String msg){
        return getMap(data, msg, SUCCESS);
    }

    private static Map<String, Object> getMap(Object data, String msg, int success) {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put(CODE, success);
        map.put(DATA, data);
        map.put(MSG, msg);
        return map;
    }

    public static Map<String, Object> success(Object data){
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put(CODE, SUCCESS);
        map.put(DATA, data);
        return map;
    }

    public static Map<String, Object> errno(Object data){
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put(ERRNO, ERROR);
        map.put(DATA, data);
        return map;
    }

    public static Map<String, Object> error(Object data, String msg){
        return getMap(data, msg, ERROR);
    }

    public static Map<String, java.io.Serializable> error(String msg){
        Map<String, java.io.Serializable> map = new HashMap<String, java.io.Serializable>(3);
        map.put(CODE, ERROR);
        map.put(MSG, msg);
        return map;
    }

    public static Map<String, Object> error(Object data){
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put(CODE, ERROR);
        map.put(DATA, data);
        return map;
    }

}
