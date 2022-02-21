package com.github.guokaia.mekatok.context.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取容器中用于转换JSON的对象
 * @author GuoKai
 * @date 2022/2/3
 */
@Component
public class JsonFormatHolder {

    private JsonFormatHolder(){}

    /**
     * jackson 的转换对象
     */
    private static ObjectMapper mapper;

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        JsonFormatHolder.mapper = mapper;
    }


    public static ObjectMapper get(){
        return JsonFormatHolder.mapper;
    }

}
