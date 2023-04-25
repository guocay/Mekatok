package com.github.guokaia.mekatok.dic.service;

import com.github.guokaia.mekatok.context.MekatokApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 字典服务启动类
 * @author GuoKai
 * @date 2022/2/5
 */
@SpringCloudApplication
public class DicApplication {
    public static void main(String[] args) {
        MekatokApplication.run(DicApplication.class, args);
    }
}
