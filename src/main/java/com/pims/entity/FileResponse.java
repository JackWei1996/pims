package com.pims.entity;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jack魏
 * @since 2019-12-31 9:59 PM
 */
public class FileResponse extends HashMap<String, Object> {

    Map<String,Object> msgMap = new HashMap<>();

    public String error(int code, String msg){
        FileResponse result = new FileResponse();
        msgMap.put("message",msg);
        result.put("uploaded",code);
        result.put("error",msgMap);
        return JSONUtils.toJSONString(result);
    }

    public String success(int code, String fileName,String url,String msg){
        FileResponse result = new FileResponse();
        if(!StringUtils.isEmpty(msg)){
            msgMap.put("message",msg);
            result.put("error",msgMap);
        }
        result.put("uploaded",code);
        result.put("fileName",fileName);
        result.put("url",url);
        return JSONUtils.toJSONString(result);
    }
}
