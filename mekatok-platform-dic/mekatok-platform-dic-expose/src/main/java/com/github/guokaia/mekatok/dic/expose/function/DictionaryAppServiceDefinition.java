package com.github.guokaia.mekatok.dic.expose.function;

import com.github.guokaia.mekatok.common.Global;
import com.github.guokaia.mekatok.common.model.GeneralPaging;
import com.github.guokaia.mekatok.dic.expose.model.table.Dictionary;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 字典 服务定义
 * @author GuoKai
 * @date 2022/2/6
 */
@RequestMapping(Global.BASIC_SERVICE_PATH + "/dictionary")
public interface DictionaryAppServiceDefinition {

   @GetMapping("/data/page")
   GeneralPaging<Dictionary> page(@SpringQueryMap Dictionary bean);

   @GetMapping("/data/{id}")
   GeneralPaging<Dictionary> detail(@PathVariable("id") String id);

}
